package com.example.tmdbclient.presentation.tvShows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecase.GetTvShowUseCase
import com.example.tmdbclient.domain.usecase.UpdateTvShowUsecase

class TvShowViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUsecase: UpdateTvShowUsecase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

      return  TvShowViewModel(getTvShowUseCase,updateTvShowUsecase) as T
    }
}