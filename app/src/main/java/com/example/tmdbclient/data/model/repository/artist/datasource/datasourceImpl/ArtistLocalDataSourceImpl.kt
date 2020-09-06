package com.example.tmdbclient.data.model.repository.artist.datasource.datasourceImpl

import com.example.tmdbclient.data.model.artistModel.Artist
import com.example.tmdbclient.data.model.db.ArtistDao
import com.example.tmdbclient.data.model.db.TvDao
import com.example.tmdbclient.data.model.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) :
    ArtistLocalDataSource {
    override suspend fun getArtistFromDB(): List<Artist> {

            return artistDao.getAllArtist()
    }

    override suspend fun saveArtistToDb(artist: List<Artist>) {

        CoroutineScope(Dispatchers.IO).launch {

             artistDao.savedArtist(artist)

        }
    }

    override suspend fun clearAll() {

        CoroutineScope(Dispatchers.IO).launch {

            artistDao.deleteArtist()
        }
    }
}