package com.example.androidmobilecodingchallenge.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit mInstance = null;
    public static final String BASE_URL = "https://api.github.com/";
    private static ApiService apiInstance = null;

    public static synchronized ApiService getInstance() {
        if (apiInstance == null) {
            apiInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService.class);
        }
        return apiInstance;
    }
}
