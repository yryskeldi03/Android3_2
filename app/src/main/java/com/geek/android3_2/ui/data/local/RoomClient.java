package com.geek.android3_2.ui.data.local;

import android.content.Context;

import androidx.room.Room;

public class RoomClient {
    public AppDataBase provideDataBase(Context context) {
        return Room.databaseBuilder(context, AppDataBase.class, "rick-and-morty")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }
}
