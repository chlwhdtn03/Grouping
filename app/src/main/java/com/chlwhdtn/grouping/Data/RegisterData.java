package com.chlwhdtn.grouping.Data;

import com.chlwhdtn.grouping.Data.Location.Location;

public class RegisterData {

    /**
     *             @Field("id") String id,
     *             @Field("password") String password,
     *             @Field("checkPassword") String checkpassword,
     *             @Body Location location,
     *             @Field("locationName") String locationName,
     *             @Field("username") String username,
     *             @Field("deviceId") String deviceId
     */

    private String id, password, checkPassword, locationName, username, deviceId;
    private Location location;

    public RegisterData(String id, String password, String checkPassword, String locationName, String username, String deviceId, Location location) {
        this.id = id;
        this.password = password;
        this.checkPassword = checkPassword;
        this.locationName = locationName;
        this.username = username;
        this.deviceId = deviceId;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
