package com.example.tmdbclient.data.model.repository.artist.datasource

import com.example.tmdbclient.data.model.artistModel.Artist

interface ArtistLocalDataSource {

    suspend fun  getArtistFromDB():List<Artist>

    suspend fun saveArtistToDb(artist: List<Artist>)

    suspend fun  clearAll();
}