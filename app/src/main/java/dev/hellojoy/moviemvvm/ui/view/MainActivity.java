package dev.hellojoy.moviemvvm.ui.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import dev.hellojoy.moviemvvm.databinding.ActivityMainBinding;
import dev.hellojoy.moviemvvm.ui.adapters.MovieAdapter;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private ActivityMainBinding binding;
    @Inject
    MovieAdapter movieAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        binding.recyclerView.setAdapter(movieAdapter);

        viewModel.fetchMovies();

        setObservers();
    }


    private void setObservers(){
        viewModel.getMoviesList().observe(this, listDataState -> {
            switch (listDataState.status){
                case LOADING:
                    binding.progressBar.setVisibility(View.VISIBLE);
                    break;
                case ERROR:
                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(this, listDataState.message, Toast.LENGTH_SHORT).show();
                    break;
                case SUCCESS:
                    binding.progressBar.setVisibility(View.GONE);
                    movieAdapter.setListProperty(listDataState.data);
                    break;
            }
        });

    }



}