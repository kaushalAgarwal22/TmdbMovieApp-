package com.example.tmdbclient.data.model.repository.tvShow.datasource

import com.example.tmdbclient.data.model.tvshowModel.TvShow
import com.example.tmdbclient.data.model.tvshowModel.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {


    suspend fun  getTvShow(): Response <TvShowList>
}