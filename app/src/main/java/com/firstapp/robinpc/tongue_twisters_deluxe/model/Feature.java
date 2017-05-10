package com.firstapp.robinpc.tongue_twisters_deluxe.model;

public class Feature {
    private String header;
    private String description;
    private String photoLink;

    public Feature(String header, String description, String photoLink) {
        this.header = header;
        this.description = description;
        this.photoLink = photoLink;
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
