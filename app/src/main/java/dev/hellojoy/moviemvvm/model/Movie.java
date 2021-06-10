package dev.hellojoy.moviemvvm.model;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("title")
    public String title;

    @SerializedName("poster_path")
    public String imagePath;

}
