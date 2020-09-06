package com.example.tmdbclient.presentation.tvShows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecase.GetTvShowUseCase
import com.example.tmdbclient.domain.usecase.UpdateTvShowUsecase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUsecase: UpdateTvShowUsecase
) : ViewModel() {


     fun getTvShow() = liveData {

         val tvShowlist = getTvShowUseCase.execute()
         emit(tvShowlist)

     }

    fun updateTvShow() = liveData {

        val updateTvShowlist = updateTvShowUsecase.execute()
        emit(updateTvShowlist)
    }

}