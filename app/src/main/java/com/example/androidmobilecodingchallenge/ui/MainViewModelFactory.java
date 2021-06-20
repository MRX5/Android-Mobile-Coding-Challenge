package com.example.androidmobilecodingchallenge.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;

public class MainViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private Map<String,String> query;
    public MainViewModelFactory(Map<String,String>query)
    {
        this.query=query;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel(query);
    }


}
