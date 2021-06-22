package com.example.exam.database.entity;

import com.orm.SugarRecord;

import java.util.List;

public class Publication extends SugarRecord {

    private String url;
    private String source;
    private String authors;
    private String title;
    private String pubDate;
    private String country;
    private String language;
    private String description;
    private String imageUrl;
    private String content;
    private int views = 0;

    public Publication() {
    }

    public Publication(String url,
                       String source,
                       String authors,
                       String title,
                       String pubDate,
                       String country,
                       String language,
                       String description,
                       String imageUrl,
                       String content,
                       int views) {
        this.url = url;
        this.source = source;
        this.authors = authors;
        this.title = title;
        this.pubDate = pubDate;
        this.country = country;
        this.language = language;
        this.description = description;
        this.imageUrl = imageUrl;
        this.content = content;
        this.views = views;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
