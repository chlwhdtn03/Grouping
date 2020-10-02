package com.chlwhdtn.grouping.Data;

import com.chlwhdtn.grouping.Data.Location.Location;

public class User {

    public String name;
    public Location location;

    public User(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
