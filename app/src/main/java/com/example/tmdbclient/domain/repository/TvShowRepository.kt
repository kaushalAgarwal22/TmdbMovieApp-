package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.tvshowModel.TvShow

interface TvShowRepository {

    suspend fun  getShows():List<TvShow>?
    suspend fun  updateShows() : List<TvShow>?
}