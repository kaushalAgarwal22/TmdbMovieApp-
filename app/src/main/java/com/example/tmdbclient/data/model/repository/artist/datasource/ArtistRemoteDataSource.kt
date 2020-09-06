package com.example.tmdbclient.data.model.repository.artist.datasource

import com.example.tmdbclient.data.model.artistModel.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun  getArtist(): Response<ArtistList>
}