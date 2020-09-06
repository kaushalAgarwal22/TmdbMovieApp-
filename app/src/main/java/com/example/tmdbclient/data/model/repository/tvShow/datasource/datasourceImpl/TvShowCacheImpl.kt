package com.example.tmdbclient.data.model.repository.tvShow.datasource.datasourceImpl

import com.example.tmdbclient.data.model.repository.tvShow.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.model.tvshowModel.TvShow

class TvShowCacheImpl:
    TvShowCacheDataSource {

    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowFromCache(): List<TvShow> {

    return tvShowList
    }

    override suspend fun saveTvShowToCache(tvShow: List<TvShow>) {

      tvShowList.clear()

      tvShowList= ArrayList(tvShow)
    }
}