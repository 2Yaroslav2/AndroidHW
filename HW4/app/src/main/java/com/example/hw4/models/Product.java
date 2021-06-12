package com.example.hw4.models;

import java.io.Serializable;

public class Product implements Serializable {

    private String path;
    private String name;
    private int count;
    private String available;

    public Product(String path, String name, int count, String available) {
        this.path = path;
        this.name = name;
        this.count = count;
        this.available = available;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
}
