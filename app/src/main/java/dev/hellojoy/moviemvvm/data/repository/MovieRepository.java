package dev.hellojoy.moviemvvm.data.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

import dev.hellojoy.moviemvvm.model.Movie;
import dev.hellojoy.moviemvvm.model.MovieResult;
import dev.hellojoy.moviemvvm.network.MovieService;
import dev.hellojoy.moviemvvm.utils.DataState;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    MovieService movieService;
    public MutableLiveData<DataState<List<Movie>>> moviesList = new MutableLiveData<>();

    @Inject
    public MovieRepository(MovieService movieService) {
        this.movieService = movieService;
    }


    public void fetchMovies(){
        moviesList.postValue(DataState.LOADING());
        Call<MovieResult> call = movieService.getMovies();
        call.enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {
                if (response.isSuccessful()){
                    MovieResult movieResult = response.body();
                    moviesList.postValue(DataState.SUCCESS(movieResult.movies));
                }else {
                    moviesList.postValue(DataState.ERROR("request error"));
                }
            }
            @Override
            public void onFailure(Call<MovieResult> call, Throwable t) {
                moviesList.postValue(DataState.ERROR("something went wrong"));
            }
        });

    }




}
