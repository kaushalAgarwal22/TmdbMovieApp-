package com.example.tmdbclient.data.model.artistModel


import com.google.gson.annotations.SerializedName

data class ArtistList(

    @SerializedName("results")
    val artists: List<Artist>




)