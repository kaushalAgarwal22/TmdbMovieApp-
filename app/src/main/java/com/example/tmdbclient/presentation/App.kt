package com.example.tmdbclient.presentation

import android.app.Application
import com.example.tmdbclient.BuildConfig
import com.example.tmdbclient.presentation.di.AppComponent
import com.example.tmdbclient.presentation.di.Injector
import com.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.di.core.AppModule
import com.example.tmdbclient.presentation.di.core.NetModule
import com.example.tmdbclient.presentation.di.core.RemoteDataModule
import com.example.tmdbclient.presentation.di.movie.MovieSubComponent
import com.example.tmdbclient.presentation.di.tvShow.TvShowSubComponent

class App : Application(), Injector {


    private lateinit var appComponent: AppComponent
    override fun onCreate() {

        super.onCreate()



       //      appComponent  =
//            .appModule(AppModule(applicationContext))
//            .netModule(NetModule("https://api.themoviedb.org/3/"))
//            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
//            .netModule(NetModule(BuildConfig.Base_Url)


    }

    override fun createMovieSubComponent(): MovieSubComponent {

        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {

        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {

        return appComponent.artistSubComponent().create()
    }


}