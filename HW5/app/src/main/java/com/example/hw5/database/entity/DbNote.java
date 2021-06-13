package com.example.hw5.database.entity;

import com.orm.SugarRecord;

import java.io.Serializable;

public class DbNote extends SugarRecord implements Serializable {
    String note;

    public DbNote(){

    }

    public DbNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
