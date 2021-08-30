package com.geek.android3_2.ui.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.geek.android3_2.ui.data.models.Film;

import java.util.List;

@Dao
public interface FilmDao {
    @Query("SELECT * FROM film")
    List<Film> getAllFilms();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFilm(Film film);
}
