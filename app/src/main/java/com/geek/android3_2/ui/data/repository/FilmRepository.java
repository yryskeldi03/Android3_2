package com.geek.android3_2.ui.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.geek.android3_2.ui.App;
import com.geek.android3_2.ui.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmRepository {

    public MutableLiveData<List<Film>> fetchFilms() {
        MutableLiveData<List<Film>> data = new MutableLiveData<>();
        App.api.getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public MutableLiveData<Film> fetchFilmsById(String id) {
        MutableLiveData<Film> data = new MutableLiveData<>();
        App.api.getFilmById(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
