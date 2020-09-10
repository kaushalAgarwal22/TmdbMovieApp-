package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.model.api.TMDBService
import com.example.tmdbclient.data.model.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.data.model.repository.artist.datasource.datasourceImpl.ArtistRemoteDataSourceImpl
import com.example.tmdbclient.data.model.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.model.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.example.tmdbclient.data.model.repository.tvShow.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.data.model.repository.tvShow.datasource.datasourceImpl.TvShowRemoteImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String ) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDataSource
    {
        return  MovieRemoteDataSourceImpl(tmdbService,apiKey)

    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService):TvShowRemoteDataSource
    {
        return  TvShowRemoteImpl(tmdbService,apiKey)

    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService):ArtistRemoteDataSource
    {
        return  ArtistRemoteDataSourceImpl(tmdbService,apiKey)

    }
}