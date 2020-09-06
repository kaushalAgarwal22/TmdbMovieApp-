package com.example.tmdbclient.data.model.repository.tvShow.datasource.datasourceImpl

import com.example.tmdbclient.data.model.api.TMDBService
import com.example.tmdbclient.data.model.repository.tvShow.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.data.model.tvshowModel.TvShowList
import retrofit2.Response

class TvShowRemoteImpl(private  val tmdbService: TMDBService, private val apiKey: String):
    TvShowRemoteDataSource {
    override suspend fun getTvShow(): Response<TvShowList> {

        return  tmdbService.getPopularTvShows(apiKey)
    }
}