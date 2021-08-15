package com.geek.android3_2.ui.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.geek.android3_2.databinding.ActivityDetailsBinding;
import com.geek.android3_2.ui.data.models.Film;
import com.geek.android3_2.ui.data.remote.RetrofitStorage;

public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;
    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getIntent() != null){
            id = getIntent().getStringExtra("id");
        }

        new RetrofitStorage().getFilmById(id, new RetrofitStorage.SecondCallBack() {
            @Override
            public void success(Film film) {
                binding.tvTitle.setText(film.getTitle());
                binding.tvOriginalTitle.setText(film.getOriginalTitle());
                binding.tvDescription.setText(film.getDescription());
            }

            @Override
            public void failure(String msg) {
                Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}