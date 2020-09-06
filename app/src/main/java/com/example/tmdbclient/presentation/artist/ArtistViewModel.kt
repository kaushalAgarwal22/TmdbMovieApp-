package com.example.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecase.GetArtistUseCase
import com.example.tmdbclient.domain.usecase.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModel() {

    fun  getArtist()= liveData {

        val artistlist = getArtistUseCase.execute()
        emit(artistlist)
    }

    fun updateArtist()= liveData {

        val updateArtistlist =updateArtistUseCase.execute()
        emit(updateArtistlist)
    }

}