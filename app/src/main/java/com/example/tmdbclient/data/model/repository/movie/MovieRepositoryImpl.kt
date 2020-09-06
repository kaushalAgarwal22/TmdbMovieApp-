package com.example.tmdbclient.data.model.repository.movie

import android.util.Log
import com.example.tmdbclient.data.model.movieModel.Movie
import com.example.tmdbclient.data.model.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.model.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.model.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.domain.repository.MoviesRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MoviesRepository {

    override suspend fun getMovies(): List<Movie>? {

      return  getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {

        val newListOfMovies = getMovieFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)

        return newListOfMovies

    }



    suspend fun getMovieFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
           val response = movieRemoteDataSource.getMovies()
           val body =  response.body()
            if(body!=null)
            {
              movieList= body.movies
            }

        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())

        }

        return  movieList
    }


    suspend fun  getMoviesFromDb():List<Movie>
    {
        lateinit var movieList: List<Movie>

        try {
           movieList =movieLocalDataSource.getMoviesFromDB()

            if(movieList.size>0)
            {
               return movieList
            }
            else{
                movieList = getMovieFromApi()
                movieLocalDataSource.saveMoviesToDB(movieList)
            }

        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())

        }

        return  movieList
    }


    suspend fun  getMoviesFromCache(): List<Movie>
    {
        lateinit var movieList: List<Movie>

        try {
            movieList =movieCacheDataSource.getMoviesFromCache()

            if(movieList.size>0)
            {
                return movieList
            }
            else{
                movieList = getMoviesFromDb()
                movieCacheDataSource.saveMoviesToCache(movieList)
            }

        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())

        }

        return  movieList

    }
}