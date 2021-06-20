package com.example.androidmobilecodingchallenge.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidmobilecodingchallenge.R;
import com.example.androidmobilecodingchallenge.model.Repo;

import java.util.ArrayList;
import java.util.List;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.viewHolder> {

    private List<Repo> repositories;
    private Context context;
    private RecyclerBottomListener listener;

    public ReposAdapter(Context context, RecyclerBottomListener listener) {
        repositories = new ArrayList<>();
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repository_layout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.bind(repositories.get(position));
        if (position == repositories.size() - 1) {
            listener.OnBottomReached();
        }
    }

    @Override
    public int getItemCount() {
        if (repositories == null) return 0;
        return repositories.size();
    }

    public void setRepositories(List<Repo> repositories) {

        this.repositories.addAll(repositories);
        Handler handler= new Handler(Looper.getMainLooper());
        Runnable runnable = () -> notifyDataSetChanged();
        handler.post(runnable);
    }

    class viewHolder extends RecyclerView.ViewHolder {
        private TextView repoName;
        private TextView repoDescription;
        private TextView repoOwner;
        private TextView stars;
        private ImageView userImage;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            repoName = itemView.findViewById(R.id.repo_name);
            repoDescription = itemView.findViewById(R.id.repo_description);
            repoOwner = itemView.findViewById(R.id.owner_name);
            stars = itemView.findViewById(R.id.repo_stars);
            userImage = itemView.findViewById(R.id.user_image);
        }

        public void bind(Repo repo) {
            repoName.setText(repo.getName());
            repoDescription.setText(repo.getDescription());
            String star_count = String.valueOf(repo.getStargazers_count());
            if(repo.getStargazers_count()>=1000){
                float stars=repo.getStargazers_count()/1000;
                star_count=String.valueOf(stars)+'k';
            }
            else
            {
                int stars=(int)repo.getStargazers_count();
                star_count=String.valueOf(stars);
            }
            stars.setText(star_count);
            repoOwner.setText(repo.getOwner().getOwnerName());
            Glide.with(context).load(repo.getOwner().getOwnerImageUrl()).into(userImage);
        }
    }

    public interface RecyclerBottomListener {
        void OnBottomReached();
    }
}
