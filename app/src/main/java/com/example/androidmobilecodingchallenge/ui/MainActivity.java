package com.example.androidmobilecodingchallenge.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.androidmobilecodingchallenge.R;
import com.example.androidmobilecodingchallenge.adapter.ReposAdapter;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ReposAdapter.RecyclerBottomListener {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ReposAdapter adapter;
    private MainViewModel viewModel;
    private int currPage = 1;
    private final int PER_PAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Trending Repos");
        progressBar = findViewById(R.id.progress_bar);

        setupRecyclerView();
        setupViewModel();

        viewModel.getRepos().observe(this,repos->{
            if(progressBar.getVisibility()==View.VISIBLE){
                progressBar.setVisibility(View.GONE);
            }
            adapter.setRepositories(repos);
        });

    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.repo_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        adapter = new ReposAdapter(this, this);
        recyclerView.setAdapter(adapter);
    }

    private void setupViewModel() {
        MainViewModelFactory factory=new MainViewModelFactory(preparQuery());
        viewModel = ViewModelProviders.of(this,factory).get(MainViewModel.class);
    }

    private Map<String, String> preparQuery() {
        Map<String, String> query = new HashMap<>();
        query.put("q", "created:>2017-10-22");
        query.put("sort", "stars");
        query.put("order", "desk");
        query.put("page", String.valueOf(currPage));
        query.put("per_page", String.valueOf(PER_PAGE));

        return query;
    }

    private void getRepositoriesList() {
        Map<String, String> query = preparQuery();
        viewModel.getRepositoriesList(query);
    }

    @Override
    public void OnBottomReached() {
        currPage++;
        getRepositoriesList();
    }
}