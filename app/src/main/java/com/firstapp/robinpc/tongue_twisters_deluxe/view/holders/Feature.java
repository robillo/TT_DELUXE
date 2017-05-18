package com.firstapp.robinpc.tongue_twisters_deluxe.view.holders;

public class Feature {
    private String header;
    private String description;
    private String photoLink;
    private int position;

    public Feature(String header, String description, String photoLink, int position) {
        this.header = header;
        this.description = description;
        this.photoLink = photoLink;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }
}
