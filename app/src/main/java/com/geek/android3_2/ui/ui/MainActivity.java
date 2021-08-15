package com.geek.android3_2.ui.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.geek.android3_2.databinding.ActivityMainBinding;
import com.geek.android3_2.ui.adapters.FilmAdapter;
import com.geek.android3_2.ui.data.models.Film;
import com.geek.android3_2.ui.data.remote.RetrofitStorage;

import java.util.List;

public class MainActivity extends AppCompatActivity implements FilmAdapter.OnItemClickListener {
    private FilmAdapter adapter;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter = new FilmAdapter();
        adapter.setOnItemClickListener(this);
        new RetrofitStorage().getFilms(new RetrofitStorage.MyCallback() {
            @Override
            public void success(List<Film> film) {
                adapter.setList(film);
                binding.rvMain.setAdapter(adapter);
                binding.rvMain.addItemDecoration(new DividerItemDecoration(getBaseContext(), DividerItemDecoration.VERTICAL));
            }

            @Override
            public void failure(String msg) {
                Toast.makeText(getBaseContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(String id) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}