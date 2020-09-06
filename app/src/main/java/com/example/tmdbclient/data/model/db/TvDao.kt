package com.example.tmdbclient.data.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclient.data.model.tvshowModel.TvShow

@Dao
interface TvDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  savedTvShows(show: List<TvShow>)


    @Query("DELETE FROM  Popular_Tv_Show")
    suspend fun  deleteShows()


    @Query("SELECT * FROM POPULAR_TV_SHOW")
    suspend fun getTvShows(): List<TvShow>

}