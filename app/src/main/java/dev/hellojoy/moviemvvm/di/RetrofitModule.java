package dev.hellojoy.moviemvvm.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import dev.hellojoy.moviemvvm.network.MovieService;
import dev.hellojoy.moviemvvm.utils.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@InstallIn(SingletonComponent.class)
@Module
public class RetrofitModule {

    @Provides
    @Singleton
    Retrofit.Builder provideRetrofit(){
        return new Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create());
    }

    @Provides
    @Singleton
    MovieService provideMovieService(Retrofit.Builder builder){
        return builder.build().create(MovieService.class);
    }


}
