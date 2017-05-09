package com.example.gabor.mylibrary;

/**
 * Created by gabor on 3/26/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;


public class Book implements Parcelable {

    private String image;
    private String title;
    private int overview;
    private int vote;
    private String release;

    public Book() {
        super();
    }

    public Book(String image, String title, int overview, int vote, String release) {
        this.image = image;
        this.title = title;
        this.overview = overview;
        this.vote = vote;
        this.release = release;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOverview(int overview) {
        this.overview = overview;
    }

    public int getOverview() {
        return overview;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public int getVote() {
        return vote;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getRelease() {
        return release;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image);
        dest.writeString(title);
        dest.writeInt(overview);
        dest.writeDouble(vote);
        dest.writeString(release);
    }

    public static final Parcelable.Creator CREATOR
            = new Parcelable.Creator() {
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public Book(Parcel in) {
        image = in.readString();
        title = in.readString();
        overview = in.readInt();
        vote = in.readInt();
        release = in.readString();
    }
}
