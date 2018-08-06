package com.example.android.bhubaneswartourguide;

public class Tour {

    private int mLoctionImage;
    private String mLocationName;
    private String mLocationAddress;

    public Tour(int mLoctionImage, String mLocationName, String mLocationAddress) {
        this.mLoctionImage = mLoctionImage;
        this.mLocationName = mLocationName;
        this.mLocationAddress = mLocationAddress;
    }

    public int getmLoctionImage() {
        return mLoctionImage;
    }

    public String getmLocationName() {
        return mLocationName;
    }

    public String getmLocationAddress() {
        return mLocationAddress;
    }
}
