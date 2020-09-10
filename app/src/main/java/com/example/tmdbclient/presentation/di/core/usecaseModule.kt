package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.domain.repository.ArtistRepository
import com.example.tmdbclient.domain.repository.MoviesRepository
import com.example.tmdbclient.domain.repository.TvShowRepository
import com.example.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class usecaseModule {


    @Provides
    fun providesGetMovieUseCase(moviesRepository: MoviesRepository): GetMoviesUseCase {
        return GetMoviesUseCase(moviesRepository)


    }
    @Provides
    fun providesUpdateMovieUseCase(moviesRepository: MoviesRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(moviesRepository)


    }
    @Provides
    fun providesGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase {
        return GetArtistUseCase(artistRepository)


    }
    @Provides
    fun providesUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUseCase {
        return UpdateArtistUseCase(artistRepository)


    }

    @Provides
    fun providesGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowUseCase {
        return GetTvShowUseCase(tvShowRepository)


    }
    @Provides
    fun providesUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUsecase {
        return UpdateTvShowUsecase(tvShowRepository)


    }
}