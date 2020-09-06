package com.example.tmdbclient.data.model.api

import com.example.tmdbclient.data.model.artistModel.ArtistList
import com.example.tmdbclient.data.model.movieModel.MovieList
import com.example.tmdbclient.data.model.tvshowModel.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apiKey:String): Response<MovieList>


    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<ArtistList>

}