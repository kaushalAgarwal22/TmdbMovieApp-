package com.example.tmdbclient.data.model.movieModel


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Popular_Movies")
data class Movie(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String

)