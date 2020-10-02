package com.chlwhdtn.grouping.Data.Location;

import android.net.Uri;

/**
 * 장소를 위한 클래스
 */
public class Place extends Location {

    private String placeName;
    private Uri placePhoto;

    /**
     * @param lat 위도
     * @param lnt 경도
     */
    public Place(int lat, int lnt, String placeName) {
        super(lat, lnt);
        this.placeName = placeName;
    }
    public Place(Location loc, String placeName) {
        super(loc.getLat(), loc.getLat());
        this.placeName = placeName;
    }

    public Place(int lat, int lnt, String placeName, Uri placePhoto) {
        super(lat, lnt);
        this.placeName = placeName;
        this.placePhoto = placePhoto;
    }
    public Place(Location loc, String placeName, Uri placePhoto) {
        super(loc.getLat(), loc.getLat());
        this.placeName = placeName;
        this.placePhoto = placePhoto;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Uri getPlacePhoto() {
        return placePhoto;
    }

    public void setPlacePhoto(Uri placePhoto) {
        this.placePhoto = placePhoto;
    }
}
