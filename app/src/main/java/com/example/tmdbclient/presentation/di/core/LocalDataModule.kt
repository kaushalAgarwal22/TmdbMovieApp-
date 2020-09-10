package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.model.db.ArtistDao
import com.example.tmdbclient.data.model.db.MovieDao
import com.example.tmdbclient.data.model.db.TvDao
import com.example.tmdbclient.data.model.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.model.repository.artist.datasource.datasourceImpl.ArtistLocalDataSourceImpl
import com.example.tmdbclient.data.model.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.model.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.example.tmdbclient.data.model.repository.tvShow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.model.repository.tvShow.datasource.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }


}