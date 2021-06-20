package com.example.androidmobilecodingchallenge;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androidmobilecodingchallenge.network.ApiClient;
import com.example.androidmobilecodingchallenge.model.Repo;
import com.example.androidmobilecodingchallenge.model.RepoResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private static Repository mInstance = new Repository();

    public static Repository getInstance() {
        return mInstance;
    }

    private MutableLiveData<List<Repo>> repos = new MutableLiveData<>();

    public MutableLiveData<List<Repo>> getRepositoriesList(Map<String, String> query) {
        Call<RepoResponse> call = ApiClient.getInstance().getRepositories(query);
        call.enqueue(new Callback<RepoResponse>() {
            @Override
            public void onResponse(Call<RepoResponse> call, Response<RepoResponse> response) {
                if (response.isSuccessful()) {
                    repos.setValue(response.body().getRepositories());
                }
            }

            @Override
            public void onFailure(Call<RepoResponse> call, Throwable t) {

            }
        });
        return repos;
    }
}
