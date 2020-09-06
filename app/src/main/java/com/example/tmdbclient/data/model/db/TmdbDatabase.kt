package com.example.tmdbclient.data.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbclient.data.model.artistModel.Artist
import com.example.tmdbclient.data.model.movieModel.Movie
import com.example.tmdbclient.data.model.tvshowModel.TvShow

@Database (entities = [Movie::class,Artist::class,TvShow::class],version = 1,exportSchema = false)
abstract class TmdbDatabase :RoomDatabase(){

    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvDao
    abstract fun artistDao(): ArtistDao



}