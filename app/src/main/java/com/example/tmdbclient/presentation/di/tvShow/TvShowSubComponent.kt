package com.example.tmdbclient.presentation.di.tvShow

import com.example.tmdbclient.presentation.artist.ArtistActivity
import com.example.tmdbclient.presentation.tvShows.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)


    @Subcomponent.Factory
    interface  Factory{

        fun create():TvShowSubComponent
    }
}