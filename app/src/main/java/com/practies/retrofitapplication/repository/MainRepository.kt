package com.practies.retrofitapplication.repository

import com.practies.retrofitapplication.api.ApiService

class MainRepository(private val api:ApiService):BaseRepository() {

  suspend  fun getPopularMovies()=safeApiCall{

        api.getPopularMovies()

    }

    suspend fun getUpcomingMovies()=safeApiCall {
        api.getUpComingMovies()
    }
    suspend fun getTrendingMovies()=safeApiCall {
        api.getNowPlaying()
    }

    suspend fun getTopRatedMovies()=safeApiCall {
        api.getTopRatedMovies()
    }

}