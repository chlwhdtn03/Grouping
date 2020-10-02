package com.chlwhdtn.grouping.Data;

import com.chlwhdtn.grouping.Data.Location.Place;

import java.util.Date;

public class Schedule {
    private String name;
    private Group group;
    private Date date;
    private Place place;

    public Schedule(String name, Group group, Date date) {
        this.name = name;
        this.group = group;
        this.date = date;
    }

    public Schedule(String name, Group group, Date date, Place place) {
        this.name = name;
        this.group = group;
        this.date = date;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
