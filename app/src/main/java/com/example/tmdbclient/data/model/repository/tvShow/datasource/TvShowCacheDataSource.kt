package com.example.tmdbclient.data.model.repository.tvShow.datasource

import com.example.tmdbclient.data.model.tvshowModel.TvShow

interface TvShowCacheDataSource {

    suspend fun  getTvShowFromCache():List<TvShow>

    suspend fun  saveTvShowToCache(tvShow: List<TvShow>)
}