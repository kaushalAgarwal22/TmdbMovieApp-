package com.example.tmdbclient.data.model.repository.movie.datasource

import com.example.tmdbclient.data.model.movieModel.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun  getMovies(): Response<MovieList>


}