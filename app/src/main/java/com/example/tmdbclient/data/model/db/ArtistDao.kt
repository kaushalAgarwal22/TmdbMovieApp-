package com.example.tmdbclient.data.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclient.data.model.artistModel.Artist

@Dao
interface ArtistDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savedArtist(artist: List<Artist>)


    @Query("DELETE FROM popular_Artists")
    suspend fun deleteArtist()


    @Query("SELECT * FROM popular_Artists")
    suspend fun getAllArtist(): List<Artist>

}