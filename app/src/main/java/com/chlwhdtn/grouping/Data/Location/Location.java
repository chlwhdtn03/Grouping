package com.chlwhdtn.grouping.Data.Location;

/**
 * 일반 위치를 위한 클래스
 */
public class Location {
    private int Lat, Lnt;

    /**
     * @param lat 위도
     * @param lnt 경도
     */
    public Location(int lat, int lnt) {
        Lat = lat;
        Lnt = lnt;
    }

    /**
     * @return 위도
     */
    public int getLat() {
        return Lat;
    }

    public void setLat(int lat) {
        Lat = lat;
    }

    /**
     * @return 경도
     */
    public int getLnt() {
        return Lnt;
    }

    public void setLnt(int lnt) {
        Lnt = lnt;
    }
}
