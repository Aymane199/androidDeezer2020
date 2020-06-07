package com.example.androiddeezer2020.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androiddeezer2020.DezeerMediaPlayer;
import com.example.androiddeezer2020.ListAlbumsActivity;
import com.example.androiddeezer2020.R;
import com.example.androiddeezer2020.service.data.Track;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolder> {
    private static final String TAG = "AdapterTrack";

    private List<Track> listTrack;
    MediaPlayer mPlayer ;
    public Context context;
    TextView text_state;
    TextView text_name_track;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textTrackName;
        private ImageView imageView;
        private View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            //c'est ici que l'on fait nos findView
            textTrackName = (TextView) itemView.findViewById(R.id.title_track);
            imageView = (ImageView) itemView.findViewById(R.id.play_track);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public TrackAdapter(List<Track> listTrack, TextView textState, TextView text_name_track) {
        this.listTrack = listTrack;
        this.text_state = textState;
        this.text_name_track = text_name_track;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TrackAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_track, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Track track = listTrack.get(position);

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textTrackName.setText(track.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "click on <" + track.getTitle()+ ">");
                try {
                    DezeerMediaPlayer.getInstance().playTrack(position);
                    text_state.setText(DezeerMediaPlayer.getInstance().getState());
                    text_name_track.setText(DezeerMediaPlayer.getInstance().getTrackName());

                } catch (IOException e) {
                    e.printStackTrace();
                }
//                Intent intent = new Intent(view.getContext(), ListAlbumsActivity.class);
//                intent.putExtra("track", track.getTitle());
//                view.getContext(). startActivity(intent);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listTrack.size();
    }
}
