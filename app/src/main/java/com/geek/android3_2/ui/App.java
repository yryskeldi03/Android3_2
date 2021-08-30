package com.geek.android3_2.ui;

import android.app.Application;

import androidx.room.Room;

import com.geek.android3_2.ui.data.local.AppDataBase;
import com.geek.android3_2.ui.data.remote.GhibliApi;
import com.geek.android3_2.ui.data.remote.RetrofitBuilder;
import com.geek.android3_2.ui.data.repository.FilmRepository;

public class App extends Application {
    public static GhibliApi api;
    public static FilmRepository repository;
    public static AppDataBase dataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        dataBase = Room.databaseBuilder(this, AppDataBase.class, "rick-and-morty")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        api = new RetrofitBuilder().provideApi();
        repository = new FilmRepository();
    }
}
