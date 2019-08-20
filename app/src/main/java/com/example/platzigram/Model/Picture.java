package com.example.platzigram.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Picture implements Parcelable{

    private String picture;
    private String userName;
    private String time;
    private String likeNumber = "0";

    public Picture(String picture, String userName, String time, String likeNumber) {
        this.picture = picture;
        this.userName = userName;
        this.time = time;
        this.likeNumber = likeNumber;
    }


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(String likeNumber) {
        this.likeNumber = likeNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.picture);
        parcel.writeString(this.userName);
        parcel.writeString(this.time);
        parcel.writeString(this.likeNumber);
    }

    protected Picture(Parcel in){
        this.picture = in.readString();
        this.userName = in.readString();
        this.time = in.readString();
        this.likeNumber = in.readString();
    }

    public static final Creator<Picture> CREATOR = new Creator<Picture>() {
        @Override
        public Picture createFromParcel(Parcel source) {
            return new Picture(source);
        }

        @Override
        public Picture[] newArray(int size) {
            return new Picture[size];
        }
    };
}
