package com.example.androidmobilecodingchallenge.model;

import com.google.gson.annotations.SerializedName;

public class Repo {
    private String name;
    private String description;
    private float stargazers_count;
    private Owner owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public float getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(float stargazers_count) {
        this.stargazers_count = stargazers_count;
    }


}
