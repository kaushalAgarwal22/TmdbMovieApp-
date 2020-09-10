package com.example.tmdbclient.presentation.di.movie

import com.example.tmdbclient.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.example.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovietScope
    @Provides
    fun providesMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMovieUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {

        return MovieViewModelFactory(getMoviesUseCase, updateMovieUseCase)
    }
}