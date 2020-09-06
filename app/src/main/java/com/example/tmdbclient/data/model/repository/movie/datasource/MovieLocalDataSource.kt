package com.example.tmdbclient.data.model.repository.movie.datasource

import com.example.tmdbclient.data.model.movieModel.Movie

interface MovieLocalDataSource {

    suspend fun  getMoviesFromDB(): List<Movie>

    suspend fun  saveMoviesToDB(movies: List<Movie>)

    suspend fun  clearAll()
}