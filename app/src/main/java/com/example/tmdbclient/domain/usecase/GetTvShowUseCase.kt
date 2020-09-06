package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.model.tvshowModel.TvShow
import com.example.tmdbclient.domain.repository.TvShowRepository

class GetTvShowUseCase(private  val tvShowRepository: TvShowRepository) {


    suspend fun  execute():List<TvShow>? = tvShowRepository.getShows()
}