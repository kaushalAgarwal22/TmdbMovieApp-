package com.example.tmdbclient.data.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclient.data.model.movieModel.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  savedMovies(movies : List<Movie>)


    @Query("DELETE FROM  Popular_Movies")
    suspend fun  deleteAllMovies()


    @Query("SELECT * FROM  Popular_Movies")
    suspend fun  getMovies(): List<Movie>

}