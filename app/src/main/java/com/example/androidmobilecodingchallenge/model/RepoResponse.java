package com.example.androidmobilecodingchallenge.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RepoResponse {

    @SerializedName("items")
    private List<Repo> repositories;

    public List<Repo> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repo> repositories) {
        this.repositories = repositories;
    }
}
