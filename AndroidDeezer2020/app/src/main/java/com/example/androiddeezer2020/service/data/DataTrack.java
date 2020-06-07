
package com.example.androiddeezer2020.service.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class DataTrack {

        @SerializedName("id")
        private Integer id;

        @SerializedName("title")
        private String title;

        @SerializedName("upc")
        private String upc;

        @SerializedName("link")
        private String link;

        @SerializedName("share")
        private String share;

        @SerializedName("cover")
        private String cover;

        @SerializedName("cover_small")
        private String coverSmall;

        @SerializedName("cover_medium")
        private String coverMedium;
        @SerializedName("cover_big")
        private String coverBig;
        @SerializedName("cover_xl")
        private String coverXl;
        @SerializedName("genre_id")
        private Integer genreId;
        @SerializedName("label")
        private String label;
        @SerializedName("nb_tracks")
        private Integer nbTracks;
        @SerializedName("duration")
        private Integer duration;
        @SerializedName("fans")
        private Integer fans;

        @SerializedName("rating")
        private Integer rating;

        @SerializedName("release_date")
        private String releaseDate;

        @SerializedName("record_type")
        private String recordType;

        @SerializedName("available")
        private Boolean available;

        @SerializedName("tracklist")
        private String tracklist;

        @SerializedName("explicit_lyrics")
        private Boolean explicitLyrics;

        @SerializedName("explicit_content_lyrics")
        private Integer explicitContentLyrics;

        @SerializedName("explicit_content_cover")
        private Integer explicitContentCover;

        @SerializedName("artist")
        private Artist artist;

        @SerializedName("type")
        private String type;

        @SerializedName("tracks")
        private Tracks tracks;

        public Integer getId() {
        return id;
    }

        public void setId(Integer id) {
        this.id = id;
    }

        public String getTitle() {
        return title;
    }

        public void setTitle(String title) {
        this.title = title;
    }

        public String getUpc() {
        return upc;
    }

        public void setUpc(String upc) {
        this.upc = upc;
    }

        public String getLink() {
        return link;
    }

        public void setLink(String link) {
        this.link = link;
    }

        public String getShare() {
        return share;
    }

        public void setShare(String share) {
        this.share = share;
    }

        public String getCover() {
        return cover;
    }

        public void setCover(String cover) {
        this.cover = cover;
    }

        public String getCoverSmall() {
        return coverSmall;
    }

        public void setCoverSmall(String coverSmall) {
        this.coverSmall = coverSmall;
    }

        public String getCoverMedium() {
        return coverMedium;
    }

        public void setCoverMedium(String coverMedium) {
        this.coverMedium = coverMedium;
    }

        public String getCoverBig() {
        return coverBig;
    }

        public void setCoverBig(String coverBig) {
        this.coverBig = coverBig;
    }

        public String getCoverXl() {
        return coverXl;
    }

        public void setCoverXl(String coverXl) {
        this.coverXl = coverXl;
    }

        public Integer getGenreId() {
        return genreId;
    }

        public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

        public String getLabel() {
        return label;
    }

        public void setLabel(String label) {
        this.label = label;
    }

        public Integer getNbTracks() {
        return nbTracks;
    }

        public void setNbTracks(Integer nbTracks) {
        this.nbTracks = nbTracks;
    }

        public Integer getDuration() {
        return duration;
    }

        public void setDuration(Integer duration) {
        this.duration = duration;
    }

        public Integer getFans() {
        return fans;
    }

        public void setFans(Integer fans) {
        this.fans = fans;
    }

        public Integer getRating() {
        return rating;
    }

        public void setRating(Integer rating) {
        this.rating = rating;
    }

        public String getReleaseDate() {
        return releaseDate;
    }

        public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

        public String getRecordType() {
        return recordType;
    }

        public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

        public Boolean getAvailable() {
        return available;
    }

        public void setAvailable(Boolean available) {
        this.available = available;
    }

        public String getTracklist() {
        return tracklist;
    }

        public void setTracklist(String tracklist) {
        this.tracklist = tracklist;
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

        public Tracks getTracks() {
        return tracks;
    }

        public void setTracks(Tracks tracks) {
        this.tracks = tracks;
    }

    }