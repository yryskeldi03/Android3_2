package com.geek.android3_2.ui.ui.favorites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.geek.android3_2.databinding.ActivityFavoritesBinding;
import com.geek.android3_2.ui.App;
import com.geek.android3_2.ui.adapters.FavoritesAdapter;

public class FavoritesActivity extends AppCompatActivity {
    private ActivityFavoritesBinding binding;
    private FavoritesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavoritesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter = new FavoritesAdapter();
        adapter.setList(App.dataBase.filmDao().getAllFilms());
        binding.rvFavorites.setAdapter(adapter);
    }
}