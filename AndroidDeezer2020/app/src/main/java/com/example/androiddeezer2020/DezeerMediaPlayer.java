package com.example.androiddeezer2020;

import android.media.MediaPlayer;

import com.example.androiddeezer2020.service.data.Track;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DezeerMediaPlayer {

    static public String STATE_PLAY = "playing...";
    static public String STATE_STOP = "stop";
    static public String STATE_PAUSE = "pause";
    static public String STATE_NO_TRACK_AVAILABLE = "NAN";


    static private DezeerMediaPlayer INSTANCE = new DezeerMediaPlayer();
    public MediaPlayer mediaPlayer;
    private List<Track> tracks;
    private int index;
    private String currentState;

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    private String trackName;

    private DezeerMediaPlayer() {
        mediaPlayer = new MediaPlayer();
        tracks = new ArrayList<>();
        this.index = 0;
        currentState = STATE_NO_TRACK_AVAILABLE;
        setTrackName("---");
    }

    static public DezeerMediaPlayer getInstance() {
        return INSTANCE;
    }

    void setTracks(List<Track> tracks) {
        this.tracks = tracks;
        this.currentState = STATE_STOP;
    }

    public String getState() {
        return currentState;
    }

    public void playTrack(int index) throws IOException {
        this.stopTrack();
        this.index = index;
        mediaPlayer.setDataSource(tracks.get(index).getPreview());
        mediaPlayer.prepare();
        mediaPlayer.start();
        currentState = STATE_PLAY;
        setTrackName(tracks.get(index).getTitle());
    }


    public void pauseTrack() {
        mediaPlayer.pause();
        currentState = STATE_PAUSE;
    }

    public void continueTrack() {
        mediaPlayer.start();
        currentState = STATE_PLAY;
    }

    public void stopTrack() {
        mediaPlayer.stop();
        mediaPlayer.reset();
        currentState = STATE_STOP;
    }

    public void previousTrack() throws IOException {
        this.stopTrack();
        --this.index;
        if(this.index == -1)
            this.index =  tracks.size()-1;
        this.playTrack(this.index);
    }

    public void nextTrack() throws IOException {
        this.stopTrack();
        this.index = (this.index + 1) % tracks.size();
        this.playTrack(this.index);
    }


}
