package com.example.tmdbclient.data.model.repository.tvShow.datasource.datasourceImpl

import com.example.tmdbclient.data.model.db.TvDao
import com.example.tmdbclient.data.model.repository.tvShow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.model.tvshowModel.TvShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private  val tvDao :TvDao) :
    TvShowLocalDataSource {
    override suspend fun getTvShowfromDb(): List<TvShow> {

      return  tvDao.getTvShows()
    }

    override suspend fun saveTvShowtoDb(tvShow: List<TvShow>) {

      CoroutineScope(IO).launch {

         tvDao.savedTvShows(tvShow)
      }
    }

    override suspend fun clearAll() {

        CoroutineScope(Dispatchers.IO).launch {

            tvDao.deleteShows()

        }
    }
}