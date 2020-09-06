package com.example.tmdbclient.data.model.repository.movie.datasourceImpl

import com.example.tmdbclient.data.model.db.MovieDao
import com.example.tmdbclient.data.model.movieModel.Movie
import com.example.tmdbclient.data.model.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) :
    MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {

        return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {

        CoroutineScope(Dispatchers.IO).launch {

            movieDao.savedMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()

        }
    }
}