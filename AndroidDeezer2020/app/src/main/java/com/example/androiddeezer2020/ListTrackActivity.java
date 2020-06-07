package com.example.androiddeezer2020;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.androiddeezer2020.adapter.TrackAdapter;
import com.example.androiddeezer2020.service.DeezerService;
import com.example.androiddeezer2020.service.data.DataTrack;
import com.example.androiddeezer2020.service.data.Track;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListTrackActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    public static final DezeerMediaPlayer DEZEER_MEDIA_PLAYER = DezeerMediaPlayer.getInstance();
    private static final String TAG = "ListTrackActivity";
    List<Track> tracks;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;
    private ImageView button_start, button_next, button_previous, button_pause, button_stop;
    private TextView text_state, text_name_track;
    private SeekBar songProgressBar;
    private Handler mHandler = new Handler();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_track);
        Toolbar toolbar = findViewById(R.id.toolbar_track);
        setSupportActionBar(toolbar);

        progressBar = findViewById(R.id.progress_circular_track);
        hideProgress();

        button_start = findViewById(R.id.mp_play);
        button_pause = findViewById(R.id.mp_pause);
        button_next = findViewById(R.id.mp_next);
        button_previous = findViewById(R.id.mp_previous);
        button_stop = findViewById(R.id.mp_stop);
        text_state = findViewById(R.id.mp_state);
        text_name_track = findViewById(R.id.mp_track_name);
        songProgressBar = findViewById(R.id.songProgressBar);

        button_start.setOnClickListener(this);
        button_pause.setOnClickListener(this);
        button_next.setOnClickListener(this);
        button_previous.setOnClickListener(this);
        button_stop.setOnClickListener(this);
        songProgressBar.setOnSeekBarChangeListener(this);

        songProgressBar.setProgress(0);
        songProgressBar.setMax(100);
        songProgressBar.setEnabled(false);
        songProgressBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        songProgressBar.getThumb().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        updateProgressBar();

        recyclerView = (RecyclerView) findViewById(R.id.track_recycler_view);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final String track = getIntent().getStringExtra("album");
        final String albumName = getIntent().getStringExtra("albumName");
        listTrackFill(track);
        toolbar.setTitle(albumName);
    }

    private void listTrackFill(String query) {
        Snackbar.make(findViewById(android.R.id.content),
                "Search " + query,
                Snackbar.LENGTH_SHORT).show();
        showProgress();

        Response.Listener<DataTrack> rep = new Response.Listener<DataTrack>() {
            @Override
            public void onResponse(DataTrack response) {
                Log.d(TAG, "searchTrack Found " + response.getNbTracks() + " track");
                tracks = response.getTracks().getData();
                DEZEER_MEDIA_PLAYER.setTracks(tracks);
                TrackAdapter mAdapter = new TrackAdapter(tracks,text_state, text_name_track);
                recyclerView.setAdapter(mAdapter);
                hideProgress();
            }
        };
        final Response.ErrorListener error = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "searchTrack onErrorResponse: " + error.getMessage());
                hideProgress();
            }
        };

        DeezerService.searchTrack(ListTrackActivity.this, query, rep, error);
    }

    @Override
    public void onClick(View v) {
        try {
            if (DEZEER_MEDIA_PLAYER.getState() != DezeerMediaPlayer.STATE_NO_TRACK_AVAILABLE) {
                if (v.getId() == R.id.mp_play) {
                    if (DEZEER_MEDIA_PLAYER.getState() == DezeerMediaPlayer.STATE_STOP)
                    {
                        DEZEER_MEDIA_PLAYER.playTrack(0);

                    }
                    if (DEZEER_MEDIA_PLAYER.getState() == DezeerMediaPlayer.STATE_PAUSE)
                    {
                        DEZEER_MEDIA_PLAYER.continueTrack();
                    }
                }
                if (v.getId() == R.id.mp_pause) {
                    if (DEZEER_MEDIA_PLAYER.getState() == DezeerMediaPlayer.STATE_PLAY)
                    {
                        DEZEER_MEDIA_PLAYER.pauseTrack();
                    }
                }
                if (v.getId() == R.id.mp_stop) {
                    if (DEZEER_MEDIA_PLAYER.getState() == DezeerMediaPlayer.STATE_PLAY ||
                            DEZEER_MEDIA_PLAYER.getState() == DezeerMediaPlayer.STATE_PAUSE){
                        DEZEER_MEDIA_PLAYER.stopTrack();
                    }
                }
                if (v.getId() == R.id.mp_next) {
                    DEZEER_MEDIA_PLAYER.nextTrack();
                }
                if (v.getId() == R.id.mp_previous) {
                    DEZEER_MEDIA_PLAYER.previousTrack();

                }
                updateProgressBar();
                updateState();
            }


        } catch (Exception e) {

        }
    }

    private void updateState(){
        text_name_track.setText(DEZEER_MEDIA_PLAYER.getTrackName());
        text_state.setText(DEZEER_MEDIA_PLAYER.getState());
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }
    public void updateProgressBar() {
        mHandler.postDelayed(mUpdateTimeTask, 100);
    }

    private Runnable mUpdateTimeTask = new Runnable() {
        public void run() {
            long totalDuration = DEZEER_MEDIA_PLAYER.mediaPlayer.getDuration();
            long currentDuration = DEZEER_MEDIA_PLAYER.mediaPlayer.getCurrentPosition();

            long percentProgress;
            try {
                percentProgress =currentDuration*100/ totalDuration ;
            }catch(ArithmeticException r){
                percentProgress =0;
            }
            // Updating progress bar
            int progress = (int)(percentProgress);
            //Log.d("Progress", ""+progress);
            songProgressBar.setProgress(progress);

            mHandler.postDelayed(this, 100);
            // Running this thread after 100 milliseconds
            if(progress == 100)
            {
                button_next.callOnClick();
                updateState();
            }
        }
    };

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

        // remove message Handler from updating progress bar
        mHandler.removeCallbacks(mUpdateTimeTask);
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
