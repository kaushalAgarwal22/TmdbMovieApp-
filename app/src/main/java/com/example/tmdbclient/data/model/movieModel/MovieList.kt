package com.example.tmdbclient.data.model.movieModel


import com.google.gson.annotations.SerializedName

data class MovieList(

    @SerializedName("results")
    val movies: List<Movie>

)