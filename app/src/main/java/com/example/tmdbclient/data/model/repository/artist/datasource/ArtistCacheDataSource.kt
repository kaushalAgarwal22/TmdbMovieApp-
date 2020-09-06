package com.example.tmdbclient.data.model.repository.artist.datasource

import com.example.tmdbclient.data.model.artistModel.Artist

interface ArtistCacheDataSource {

    suspend fun  getArtistFromCache():List<Artist>

    suspend fun  saveArtistsToCache(artist: List<Artist>)
}