package com.geek.android3_2.ui.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geek.android3_2.ui.App;
import com.geek.android3_2.ui.data.models.Film;

import java.util.List;

public class MainViewModel extends ViewModel{

    MutableLiveData<List<Film>> fetchFilms(){
        return App.repository.fetchFilms();
    }
}
