package com.example.tmdbclient.data.model.repository.artist.datasource.datasourceImpl

import com.example.tmdbclient.data.model.artistModel.Artist
import com.example.tmdbclient.data.model.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl:
    ArtistCacheDataSource {

    private  var artistList = ArrayList<Artist>()
    override suspend fun getArtistFromCache(): List<Artist> {
        return  artistList
    }

    override suspend fun saveArtistsToCache(artist: List<Artist>) {

        artistList.clear()

        artistList = ArrayList(artist)
    }
}