package com.geek.android3_2.ui.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
//    private static GhibliApi instance;

//    private RetrofitBuilder() {
//    }
//
//    public static GhibliApi getInstance() {
//        if (instance == null) {
//            instance = createRetrofit();
//        }
//        return instance;
//    }

//    private static GhibliApi createRetrofit() {
//        return new Retrofit.Builder()
//                .baseUrl("https://ghibliapi.herokuapp.com")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(GhibliApi.class);
//    }

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://ghibliapi.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public GhibliApi provideApi(){
        return retrofit.create(GhibliApi.class);
    }

}
