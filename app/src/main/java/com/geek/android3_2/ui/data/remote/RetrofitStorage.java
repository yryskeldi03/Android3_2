package com.geek.android3_2.ui.data.remote;

import com.geek.android3_2.ui.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitStorage {
//
//    public void getFilms( MyCallback callback) {
//        RetrofitBuilder.getInstance().getFilms().enqueue(new Callback<List<Film>>() {
//            @Override
//            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    callback.success(response.body());
//                }else {
//                    callback.failure(response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Film>> call, Throwable t) {
//                callback.failure(t.getLocalizedMessage());
//            }
//        });
//    }
//
//    public void getFilmById(String id, SecondCallBack callBack){
//        RetrofitBuilder.getInstance().getFilmById(id).enqueue(new Callback<Film>() {
//            @Override
//            public void onResponse(Call<Film> call, Response<Film> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    callBack.success(response.body());
//                }else {
//                    callBack.failure(response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Film> call, Throwable t) {
//                callBack.failure(t.getLocalizedMessage());
//            }
//        });
//    }

    public interface MyCallback {
        void success(List<Film> film);

        void failure(String msg);
    }

    public interface SecondCallBack{
        void success(Film film);

        void failure(String msg);
    }
}
