package com.geek.android3_2.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geek.android3_2.databinding.ItemBinding;
import com.geek.android3_2.ui.data.models.Film;

import java.util.LinkedList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {
    private List<Film> list = new LinkedList<>();
    private OnItemClickListener onItemClickListener;

    public void setList(List<Film> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public FilmAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FilmAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemBinding binding;
        public ViewHolder(ItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(Film film) {
            binding.tvDate.setText(film.getReleaseDate());
            binding.tvTitle.setText(film.getTitle());

            itemView.setOnClickListener(v -> onItemClickListener.onClick(film.getId()));
        }
    }

    public interface OnItemClickListener{
        void onClick(String id);
    }
}
