package com.example.tmdbclient.data.model.repository.movie.datasourceImpl

import com.example.tmdbclient.data.model.movieModel.Movie
import com.example.tmdbclient.data.model.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl :
    MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {

      return  movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {

      movieList.clear()
      movieList =ArrayList(movies)
    }
}