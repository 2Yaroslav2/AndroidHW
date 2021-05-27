package com.example.hw3.models;

import java.io.Serializable;

public class Photo implements Serializable {

    private String path;
    private String title;
    private String description;
    private String author;
    private String downloadDate;


    public Photo(String path, String title, String description, String author, String downloadDate) {
        this.path = path;
        this.title = title;
        this.description = description;
        this.author = author;
        this.downloadDate = downloadDate;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(String downloadDate) {
        this.downloadDate = downloadDate;
    }
}
