package com.geek.android3_2.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geek.android3_2.databinding.ItemFavoritesBinding;
import com.geek.android3_2.ui.data.models.Film;

import java.util.LinkedList;
import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {
    private List<Film> list = new LinkedList<>();

    public void setList(List<Film> list){
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public FavoritesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemFavoritesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemFavoritesBinding binding;
        public ViewHolder(@NonNull ItemFavoritesBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(Film film) {
            binding.tvDate.setText(film.getReleaseDate());
            binding.tvTitle.setText(film.getTitle());
        }
    }
}
