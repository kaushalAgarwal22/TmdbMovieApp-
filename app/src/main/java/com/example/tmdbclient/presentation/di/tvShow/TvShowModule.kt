package com.example.tmdbclient.presentation.di.tvShow

import com.example.tmdbclient.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.GetTvShowUseCase
import com.example.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.example.tmdbclient.domain.usecase.UpdateTvShowUsecase
import com.example.tmdbclient.presentation.movie.MovieViewModelFactory
import com.example.tmdbclient.presentation.tvShows.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun providesTvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowUsecase: UpdateTvShowUsecase
    ): TvShowViewModelFactory {

        return TvShowViewModelFactory(getTvShowUseCase, updateTvShowUsecase)
    }
}