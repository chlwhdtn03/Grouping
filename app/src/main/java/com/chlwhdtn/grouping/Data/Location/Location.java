package com.chlwhdtn.grouping.Data.Location;

/**
 * 일반 위치를 위한 클래스
 */
public class Location {
    private String latitude, longitude;

    /**
     * @param latitude 위도
     * @param longitude 경도
     */
    public Location(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * @return 위도
     */
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return 경도
     */
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
