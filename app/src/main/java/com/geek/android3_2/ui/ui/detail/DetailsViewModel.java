package com.geek.android3_2.ui.ui.detail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geek.android3_2.ui.App;
import com.geek.android3_2.ui.data.models.Film;

import java.util.List;

public class DetailsViewModel extends ViewModel {
    MutableLiveData<Film> fetchFilmsById(String id){
        return App.repository.fetchFilmsById(id);
    }
}
