package com.example.androidmobilecodingchallenge.network;

import com.example.androidmobilecodingchallenge.model.RepoResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiService {

    @GET("search/repositories")
    Call<RepoResponse> getRepositories(@QueryMap Map<String,String>mp);

}
