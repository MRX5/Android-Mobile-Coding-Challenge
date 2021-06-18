package com.example.androidmobilecodingchallenge.Ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidmobilecodingchallenge.Network.ApiClient;
import com.example.androidmobilecodingchallenge.model.Repo;
import com.example.androidmobilecodingchallenge.Repository;
import com.example.androidmobilecodingchallenge.model.RepoResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private Repository repository;
    public MainViewModel()
    {
        repository=Repository.getInstance();
    }

    public LiveData<List<Repo>> getRepositoryList(Map<String,String> query)
    {
        return repository.getRepos(query);
    }

}
