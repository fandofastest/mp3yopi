package com.mexmp3.onlinetopmp3;

public class kygjdfgsfsdfa {

    private String songTitle, songUri, artworkUrl, user, duration,songid;

    public kygjdfgsfsdfa(String songid,String songTitle, String songUri, String artworkUrl, String user, String duration, String likes_count) {
        this.songTitle = songTitle;
        this.songUri = songUri;
        this.artworkUrl = artworkUrl;
        this.user = user;
        this.duration = duration;
        this.songid=songid;

    }


    public String getSongid() {
        return songid;
    }

    public void setSongid(String songid) {
        this.songid = songid;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSongUri() {
        return songUri;
    }

    public void setSongUri(String songUri) {
        this.songUri = songUri;
    }

    public String getArtworkUrl() {
        return artworkUrl;
    }

    public void setArtworkUrl(String artworkUrl) {
        this.artworkUrl = artworkUrl;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getduration() {
        return duration;
    }

    public void setduration(String duration) {
        this.duration = duration;
    }
}
