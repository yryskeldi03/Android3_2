package com.geek.android3_2.ui.data.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;

import java.util.List;
@Entity
public class Film {
    @NonNull
    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("description")
    private String description;
    @SerializedName("release_date")
    private String releaseDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }




    @Override
    public String toString() {
        return "Film{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                '}';
    }
}
