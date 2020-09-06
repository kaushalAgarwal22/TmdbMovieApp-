package com.example.tmdbclient.data.model.repository.artist.datasource.datasourceImpl

import com.example.tmdbclient.data.model.api.TMDBService
import com.example.tmdbclient.data.model.artistModel.ArtistList
import com.example.tmdbclient.data.model.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apikey: String) :
    ArtistRemoteDataSource {
    override suspend fun getArtist(): Response<ArtistList> = tmdbService.getPopularArtists(apikey)


}