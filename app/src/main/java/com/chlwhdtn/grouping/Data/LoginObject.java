package com.chlwhdtn.grouping.Data;

public class LoginObject {

    private String id,password,deviceId;

    public LoginObject(String id, String password, String deviceId) {
        this.id = id;
        this.password = password;
        this.deviceId = deviceId;
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

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
