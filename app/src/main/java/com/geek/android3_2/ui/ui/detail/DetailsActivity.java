package com.geek.android3_2.ui.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.geek.android3_2.databinding.ActivityDetailsBinding;
import com.geek.android3_2.ui.data.models.Film;
import com.geek.android3_2.ui.data.remote.RetrofitStorage;
import com.geek.android3_2.ui.ui.main.MainViewModel;

public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;
    private String id;
    private DetailsViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        id = getIntent().getStringExtra("id");
        viewModel = new ViewModelProvider(this).get(DetailsViewModel.class);

        viewModel.fetchFilmsById(id).observe(this, new Observer<Film>() {
            @Override
            public void onChanged(Film film) {
                binding.tvDescription.setText(film.getDescription());
                binding.tvTitle.setText(film.getTitle());
                binding.tvOriginalTitle.setText(film.getOriginalTitle());
            }
        });
    }
}