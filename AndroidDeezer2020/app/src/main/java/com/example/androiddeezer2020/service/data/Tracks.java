package com.example.androiddeezer2020.service.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tracks {

    @SerializedName("data")
    @Expose
    private List<Track> data = null;

    public List<Track> getData() {
        return data;
    }

    public void setData(List<Track> data) {
        this.data = data;
    }

}
