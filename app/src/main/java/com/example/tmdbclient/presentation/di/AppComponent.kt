package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.di.core.*
import com.example.tmdbclient.presentation.di.movie.MovieSubComponent
import com.example.tmdbclient.presentation.di.tvShow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, CacheDataModule::class, RemoteDataModule::class, CacheDataModule::class, DatabaseModule::class, RepositoryModule::class, usecaseModule::class, NetModule::class, LocalDataModule::class])
interface AppComponent {

    fun movieSubComponent() : MovieSubComponent.Factory

    fun  artistSubComponent() : ArtistSubComponent.Factory

    fun  tvShowSubComponent() :TvShowSubComponent.Factory
}