package com.chlwhdtn.grouping.Data;

import com.chlwhdtn.grouping.Data.Location.Place;

import java.util.Date;

public class Schedule {
    private String title;
    private String group_id;
    private String date;
    private String location;
    private String owner;

    public Schedule(String title, String group_id, String date, String location) {
        this.title = title;
        this.group_id = group_id;
        this.date = date;
        this.location = location;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
