package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.model.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclient.data.model.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.model.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.data.model.repository.artist.datasource.ArtistRepositoryImpl
import com.example.tmdbclient.data.model.repository.movie.MovieRepositoryImpl
import com.example.tmdbclient.data.model.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.model.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.model.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.model.repository.tvShow.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.model.repository.tvShow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.model.repository.tvShow.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.data.model.repository.tvShow.datasource.TvShowRepositoryImpl
import com.example.tmdbclient.domain.repository.ArtistRepository
import com.example.tmdbclient.domain.repository.MoviesRepository
import com.example.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {


    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MoviesRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }


    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}