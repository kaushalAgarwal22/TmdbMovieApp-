package com.example.tmdbclient.data.model.repository.movie.datasource

import com.example.tmdbclient.data.model.movieModel.Movie

interface MovieCacheDataSource {

    suspend fun  getMoviesFromCache(): List<Movie>

    suspend fun  saveMoviesToCache(movies: List<Movie>)
}