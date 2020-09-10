package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.model.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclient.data.model.repository.artist.datasource.datasourceImpl.ArtistCacheDataSourceImpl
import com.example.tmdbclient.data.model.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.model.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.example.tmdbclient.data.model.repository.tvShow.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.model.repository.tvShow.datasource.datasourceImpl.TvShowCacheImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {


   @Singleton
   @Provides
   fun provideMovieCacheDataSource():MovieCacheDataSource
   {
       return  MovieCacheDataSourceImpl()
   }


    @Singleton
    @Provides
    fun provideTvShowCacheDataSource():TvShowCacheDataSource
    {
        return  TvShowCacheImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource():ArtistCacheDataSource
    {
        return  ArtistCacheDataSourceImpl()
    }
}