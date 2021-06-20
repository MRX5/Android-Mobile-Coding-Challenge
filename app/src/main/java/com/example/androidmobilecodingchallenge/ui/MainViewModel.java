package com.example.androidmobilecodingchallenge.ui;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidmobilecodingchallenge.model.Repo;
import com.example.androidmobilecodingchallenge.Repository;
import com.example.androidmobilecodingchallenge.model.RepoResponse;
import com.example.androidmobilecodingchallenge.network.ApiClient;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private Repository repository;
    private MutableLiveData<List<Repo>>repos;

    public MainViewModel(Map<String,String>query){
        repository = Repository.getInstance();
        repos=repository.repos;
        getRepositoriesList(query);
    }

    public void getRepositoriesList(Map<String, String> query) {
        repos=repository.getRepositoriesList(query);
    }

    public LiveData<List<Repo>> getRepos() {
        return repos;
    }
}
