package com.example.tmdbclient.presentation.di.core
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tmdbclient.data.model.db.ArtistDao
import com.example.tmdbclient.data.model.db.MovieDao
import com.example.tmdbclient.data.model.db.TmdbDatabase
import com.example.tmdbclient.data.model.db.TvDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context:Context):RoomDatabase
    {
        return Room.databaseBuilder(context,TmdbDatabase::class.java,"tmdbClient").build()
    }


    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TmdbDatabase): MovieDao
    {
        return  tmdbDatabase.movieDao()

    }

    @Singleton
    @Provides
    fun provideTvDao(tmdbDatabase: TmdbDatabase): TvDao
    {
        return  tmdbDatabase.tvShowDao()

    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TmdbDatabase): ArtistDao
    {
        return  tmdbDatabase.artistDao()

    }
}