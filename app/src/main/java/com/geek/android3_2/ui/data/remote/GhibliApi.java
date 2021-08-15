package com.geek.android3_2.ui.data.remote;

import com.geek.android3_2.ui.data.models.Film;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GhibliApi {
    @GET("films")
    Call<List<Film>> getFilms();

    @GET("/films/{id}")
    Call<Film> getFilmById(
            @Path("id") String id
    );
}
