package com.example.tmdbclient.data.model.tvshowModel


import com.google.gson.annotations.SerializedName

data class TvShowList(

    @SerializedName("results")
    val tvShows: List<TvShow>

)