package dev.hellojoy.moviemvvm.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ApplicationContext;
import dev.hellojoy.moviemvvm.databinding.ItemMovieBinding;
import dev.hellojoy.moviemvvm.model.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> list=new ArrayList<>();
    private Context context;

    @Inject
    public MovieAdapter(@ApplicationContext Context context) {
        this.context = context;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setListProperty(List<Movie> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = list.get(position);
        String imageUrl = "https://image.tmdb.org/t/p/w500"+movie.imagePath;
        Glide.with(context).load(imageUrl).into(holder.binding.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder{
        ItemMovieBinding binding;
        public MovieViewHolder(ItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
