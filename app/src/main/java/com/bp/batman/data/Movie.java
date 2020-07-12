package com.bp.batman.data;

public class Movie {

    public Movie(String title, String year, String imdbId, String type, String poster) {
        Title = title;
        Year = year;
        this.imdbId = imdbId;
        Type = type;
        Poster = poster;
    }

    private int id;
    private String Title;
    private String Year;
    private String imdbId;
    private String Type;
    private String Poster;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }
}
