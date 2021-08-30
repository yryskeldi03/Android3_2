package com.geek.android3_2.ui.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.geek.android3_2.databinding.ActivityMainBinding;
import com.geek.android3_2.ui.App;
import com.geek.android3_2.ui.adapters.FavoritesAdapter;
import com.geek.android3_2.ui.adapters.FilmAdapter;
import com.geek.android3_2.ui.data.models.Film;
import com.geek.android3_2.ui.ui.detail.DetailsActivity;
import com.geek.android3_2.ui.ui.favorites.FavoritesActivity;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FilmAdapter.OnItemClickListener {
    private FilmAdapter adapter;
    private ActivityMainBinding binding;
    private MainViewModel viewModel;
    private List<Film> list = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        adapter = new FilmAdapter();
        adapter.setOnItemClickListener(this);
        //binding.anim.setAnimation(R.raw.anim);
        viewModel.fetchFilms().observe(this, new Observer<List<Film>>() {
            @Override
            public void onChanged(List<Film> films) {
                adapter.setList(films);
                binding.rvMain.setAdapter(adapter);
                MainActivity.this.list = films;
            }
        });

        binding.btnFavorites.setOnClickListener(v -> {
            startActivity(new Intent(this, FavoritesActivity.class));
            finish();
        });

    }

    @Override
    public void onItemClick(String id) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBtnClick(String id, int position) {
        App.dataBase.filmDao().insertFilm(list.get(position));
    }
}