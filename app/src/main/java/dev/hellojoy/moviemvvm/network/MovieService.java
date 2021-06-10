package dev.hellojoy.moviemvvm.network;

import dev.hellojoy.moviemvvm.model.MovieResult;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieService {

    @GET("popular?api_key=b197548ea23c753f325138ad361e6f23")
    Call<MovieResult> getMovies();


}
