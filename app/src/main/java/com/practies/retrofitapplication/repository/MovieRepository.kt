package com.practies.retrofitapplication.repository

import com.practies.retrofitapplication.api.ApiService
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiService){

    suspend fun  getPopularMovies()=apiService.getPopularMovies()

    suspend fun  getTopRatedMovies()=apiService.getTopRatedMovies()

    suspend fun  getNowPlayingMovies()=apiService.getNowPlaying()

    suspend fun  getUpComingMovies(page:Int)=apiService.getUpComingMovies(page)

//    suspend fun  getLatestMovies():Res=ponse<ApiResponse>{
//        return RetrofitInstance.api.getLatest()
//
//    }


}
