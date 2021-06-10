package dev.hellojoy.moviemvvm;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class MovieApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
