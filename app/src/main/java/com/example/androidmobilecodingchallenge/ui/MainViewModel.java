package com.example.androidmobilecodingchallenge.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidmobilecodingchallenge.model.Repo;
import com.example.androidmobilecodingchallenge.Repository;

import java.util.List;
import java.util.Map;

public class MainViewModel extends ViewModel {

    private Repository repository;

    public MainViewModel() {
        repository = Repository.getInstance();
    }

    public LiveData<List<Repo>> getRepositoriesList(Map<String, String> query) {
        return repository.getRepos(query);
    }

}
