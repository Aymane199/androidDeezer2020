package com.example.androiddeezer2020;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.androiddeezer2020.adapter.AlbumAdapter;
import com.example.androiddeezer2020.adapter.AlbumAdapter;
import com.example.androiddeezer2020.service.DeezerService;
import com.example.androiddeezer2020.service.data.DataSearchAlbum;
import com.example.androiddeezer2020.service.data.DataSearchAlbum;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListAlbumsActivity extends AppCompatActivity {
    private static final String TAG = "ListAlbumsActivity";

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_albums);
        Toolbar toolbar = findViewById(R.id.toolbar_album);
        setSupportActionBar(toolbar);

        progressBar = findViewById(R.id.progress_circular_album);
        hideProgress();

        recyclerView = (RecyclerView) findViewById(R.id.album_recycler_view);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final String album = getIntent().getStringExtra("artist");
        listAlbumFill(album);
        toolbar.setTitle(album);
    }

    private void listAlbumFill(String query) {
        Snackbar.make(findViewById(android.R.id.content),
                "Search " + query,
                Snackbar.LENGTH_SHORT).show();
        showProgress();

        Response.Listener<DataSearchAlbum> rep = new Response.Listener<DataSearchAlbum>() {
            @Override
            public void onResponse(DataSearchAlbum response) {
                Log.d(TAG, "searchAlbum Found " + response.getTotal() + " artist");
                AlbumAdapter mAdapter = new AlbumAdapter(response.getData());
                recyclerView.setAdapter(mAdapter);
                hideProgress();
            }
        };
        final Response.ErrorListener error = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "searchAlbum onErrorResponse: " + error.getMessage());
                hideProgress();
            }
        };

        DeezerService.searchAlbum(ListAlbumsActivity.this, query, rep, error);
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
}