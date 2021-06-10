package dev.hellojoy.moviemvvm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResult {

    @SerializedName("page")
    public int pageNo;

    @SerializedName("results")
    public List<Movie> movies;


}
