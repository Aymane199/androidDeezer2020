package com.example.androiddeezer2020.service.data;

import com.google.gson.annotations.SerializedName;

public class Track {
    @SerializedName("id")
    private Integer id;

    @SerializedName("readable")
    private Boolean readable;

    @SerializedName("title")
    private String title;

    @SerializedName("title_short")
    private String titleShort;

    @SerializedName("title_version")
    private String titleVersion;

    @SerializedName("link")
    private String link;

    @SerializedName("duration")
    private Integer duration;

    @SerializedName("rank")
    private Integer rank;

    @SerializedName("explicit_lyrics")
    private Boolean explicitLyrics;

    @SerializedName("explicit_content_lyrics")
    private Integer explicitContentLyrics;

    @SerializedName("explicit_content_cover")
    private Integer explicitContentCover;

    @SerializedName("preview")
    private String preview;

    @SerializedName("artist")
    private Artist artist;

    @SerializedName("type")
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getReadable() {
        return readable;
    }

    public void setReadable(Boolean readable) {
        this.readable = readable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleShort() {
        return titleShort;
    }

    public void setTitleShort(String titleShort) {
        this.titleShort = titleShort;
    }

    public String getTitleVersion() {
        return titleVersion;
    }

    public void setTitleVersion(String titleVersion) {
        this.titleVersion = titleVersion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Boolean getExplicitLyrics() {
        return explicitLyrics;
    }

    public void setExplicitLyrics(Boolean explicitLyrics) {
        this.explicitLyrics = explicitLyrics;
    }

    public Integer getExplicitContentLyrics() {
        return explicitContentLyrics;
    }

    public void setExplicitContentLyrics(Integer explicitContentLyrics) {
        this.explicitContentLyrics = explicitContentLyrics;
    }

    public Integer getExplicitContentCover() {
        return explicitContentCover;
    }

    public void setExplicitContentCover(Integer explicitContentCover) {
        this.explicitContentCover = explicitContentCover;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
