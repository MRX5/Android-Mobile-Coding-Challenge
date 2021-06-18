package com.example.androidmobilecodingchallenge.model;

import com.google.gson.annotations.SerializedName;

public class Owner {
    @SerializedName("login")
    private String ownerName;
    @SerializedName("avatar_url")
    private String ownerImageUrl;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerImageUrl() {
        return ownerImageUrl;
    }

    public void setOwnerImageUrl(String ownerImageUrl) {
        this.ownerImageUrl = ownerImageUrl;
    }
}
