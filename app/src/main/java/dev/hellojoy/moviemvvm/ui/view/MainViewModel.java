package dev.hellojoy.moviemvvm.ui.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import dev.hellojoy.moviemvvm.data.repository.MovieRepository;
import dev.hellojoy.moviemvvm.model.Movie;
import dev.hellojoy.moviemvvm.utils.DataState;

@HiltViewModel
public class MainViewModel extends ViewModel {

    @Inject
    MovieRepository movieRepository;

    @Inject
    public MainViewModel(SavedStateHandle handle) {
    }


    public void fetchMovies(){
        movieRepository.fetchMovies();
    }

    public LiveData<DataState<List<Movie>>> getMoviesList(){
        return movieRepository.moviesList;
    }


}
