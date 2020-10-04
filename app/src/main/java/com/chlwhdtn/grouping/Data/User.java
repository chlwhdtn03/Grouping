package com.chlwhdtn.grouping.Data;

import com.chlwhdtn.grouping.Data.Location.Location;
import com.google.gson.Gson;

public class User {

    private String id;
    private String username;
    private Location location;

    public User(String id, String username, Location location) {
        this.id = id;
        this.username = username;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
