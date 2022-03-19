package com.practies.retrofitapplication.repository

import android.util.Log
import com.practies.retrofitapplication.Movie
import com.practies.retrofitapplication.api.ApiService
import com.practies.retrofitapplication.api.RetrofitInstance
import com.practies.retrofitapplication.helper.Constants
import retrofit2.Response
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiService){

    suspend fun  getPopularMovies()=apiService.getPopularMovies()

    suspend fun  getTopRatedMovies()=apiService.getTopRatedMovies()

    suspend fun  getNowPlayingMovies()=apiService.getNowPlaying()

    suspend fun  getUpComingMovies()=apiService.getUpComingMovies()

//    suspend fun  getLatestMovies():Res=ponse<Movie>{
//        return RetrofitInstance.api.getLatest()
//
//    }


}
