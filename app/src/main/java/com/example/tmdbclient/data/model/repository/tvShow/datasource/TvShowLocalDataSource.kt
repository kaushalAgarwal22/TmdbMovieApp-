package com.example.tmdbclient.data.model.repository.tvShow.datasource

import com.example.tmdbclient.data.model.tvshowModel.TvShow

interface TvShowLocalDataSource {

    suspend fun  getTvShowfromDb():List<TvShow>

    suspend fun  saveTvShowtoDb(tvShow: List<TvShow>)
    suspend fun  clearAll();

}