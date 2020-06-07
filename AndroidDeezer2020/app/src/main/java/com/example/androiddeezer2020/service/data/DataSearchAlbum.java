
package com.example.androiddeezer2020.service.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class DataSearchAlbum {

    @SerializedName("data")
    private List<Album> data = null;
    @SerializedName("total")
    private Integer total;
    @SerializedName("next")
    private String next;

    public List<Album> getData() {
        return data;
    }

    public void setData(List<Album> data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
