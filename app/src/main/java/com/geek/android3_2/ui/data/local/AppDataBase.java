package com.geek.android3_2.ui.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.geek.android3_2.ui.data.models.Film;

@Database(entities = {Film.class}, version = 4)
public abstract class AppDataBase extends RoomDatabase {
    public abstract FilmDao filmDao();
}
