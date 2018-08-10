package com.example.tarsbir.zoomcar;

public class CustomCarList {
    private String mCarName;
    private String mSeater;
    private int mImageResourceId;

    CustomCarList(String mCarName, String mSeater, int mImageResourceId) {
        this.mCarName = mCarName;
        this.mSeater = mSeater;
        this.mImageResourceId = mImageResourceId;
    }

    public String getCarName() {
        return mCarName;
    }

    public void setCarName(String mCarName) {
        this.mCarName = mCarName;
    }

    public String getSeater() {
        return mSeater;
    }

    public void setSeater(String mSeater) {
        this.mSeater = mSeater;
    }

    public int getImageResource() {
        return mImageResourceId;
    }

    public void setImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }
}
