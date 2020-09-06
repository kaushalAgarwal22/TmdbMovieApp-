package com.example.tmdbclient.data.model.repository.artist.datasource

import android.util.Log
import com.example.tmdbclient.data.model.artistModel.Artist
import com.example.tmdbclient.data.model.artistModel.ArtistList
import com.example.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtist(): List<Artist>? {

        return  getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {

          val newArtistList = getArtistFromApi()
          artistLocalDataSource.clearAll()
          artistLocalDataSource.saveArtistToDb(newArtistList)
          artistCacheDataSource.saveArtistsToCache(newArtistList)

        return  newArtistList

    }


    suspend fun getArtistFromApi(): List<Artist> {

        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDataSource.getArtist()
            val body = response.body()
            if (body != null) {

                artistList = body.artists
            }


        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())

        }
        return artistList
    }

    suspend fun  getArtistFromDB():List<Artist>
    {

        lateinit var artistList: List<Artist>

        try {
            if(artistList.size>0)
            {
               return  artistList
            }
            else {

                artistList = getArtistFromApi()
                artistLocalDataSource.saveArtistToDb(artistList)
            }


        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())

        }
        return artistList
    }

    suspend fun  getArtistFromCache():List<Artist>
    {
        lateinit var artistList: List<Artist>

        try {
            if(artistList.size>0)
            {
               return  artistList
            }
            else {
               artistList = getArtistFromDB()
               artistCacheDataSource.saveArtistsToCache(artistList)

            }


        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())

        }
        return artistList
    }
}