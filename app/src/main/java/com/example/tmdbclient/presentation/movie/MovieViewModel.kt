package com.example.tmdbclient.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

import com.example.tmdbclient.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getmoviesUseCase: GetMoviesUseCase,
    private val updatemoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {


      fun getMovies() = liveData {
          val movielist = getmoviesUseCase.execute()
          emit(movielist)
      }

      fun updateMovies()= liveData {
          val updateMovielist =  updatemoviesUseCase.execute()
          emit(updateMovielist)
      }

}


