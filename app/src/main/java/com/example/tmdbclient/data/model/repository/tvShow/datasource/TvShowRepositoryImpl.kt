package com.example.tmdbclient.data.model.repository.tvShow.datasource

import android.util.Log
import com.example.tmdbclient.data.model.repository.tvShow.datasource.datasourceImpl.TvShowCacheImpl
import com.example.tmdbclient.data.model.repository.tvShow.datasource.datasourceImpl.TvShowLocalDataSourceImpl
import com.example.tmdbclient.data.model.repository.tvShow.datasource.datasourceImpl.TvShowRemoteImpl
import com.example.tmdbclient.data.model.tvshowModel.TvShow
import com.example.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {
    override suspend fun getShows(): List<TvShow>? {

        return getTvShowFromCache()
    }

    override suspend fun updateShows(): List<TvShow>? {
        val newListOfTvShows= getTvShowFromApi()
         tvShowLocalDataSource.clearAll()
         tvShowLocalDataSource.saveTvShowtoDb(newListOfTvShows)
         tvShowCacheDataSource.saveTvShowToCache(newListOfTvShows)

        return  newListOfTvShows

    }
    suspend fun getTvShowFromApi(): List<TvShow> {
        lateinit var tvShowlist: List<TvShow>


        try {
            val response = tvShowRemoteDataSource.getTvShow()
            val body = response.body()

            if (body != null) {
                tvShowlist = body.tvShows
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())

        }
        return tvShowlist
    }

    suspend fun getTvShowFromDb(): List<TvShow> {
        lateinit var tvShowlist: List<TvShow>

        try {

            tvShowlist = tvShowLocalDataSource.getTvShowfromDb()

            if (tvShowlist.size > 0) {
                return tvShowlist
            } else {
                tvShowlist = getTvShowFromApi()
                tvShowLocalDataSource.saveTvShowtoDb(tvShowlist)
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())

        }
        return tvShowlist
    }

    suspend fun getTvShowFromCache(): List<TvShow> {
        lateinit var tvShowlist: List<TvShow>


        try {
            tvShowlist = tvShowCacheDataSource.getTvShowFromCache()

            if (tvShowlist.size > 0) {
                return tvShowlist
            } else {
                tvShowlist = getTvShowFromDb()
                tvShowCacheDataSource.saveTvShowToCache(tvShowlist)
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())

        }
        return tvShowlist
    }

}