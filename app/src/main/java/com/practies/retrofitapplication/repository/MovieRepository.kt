package com.practies.retrofitapplication.repository

import com.practies.retrofitapplication.Movie
import com.practies.retrofitapplication.api.ApiService
import com.practies.retrofitapplication.api.RetrofitInstance
import com.practies.retrofitapplication.helper.Constants
import retrofit2.Response
import javax.inject.Inject

class MovieRepository
//    suspend fun  getPopularMovies():Response<Movie>{
//        return RetrofitInstance.API.getPopularMovies()
//    }
//}

       constructor( private val ApiService: ApiService){


    suspend fun getPopularMovies()=ApiService.getPopularMovies(Constants.APIKEY)

    suspend fun getNowPlayingMovies()=ApiService.getNowPlaying(Constants.APIKEY)

    suspend fun getUpComingMovies()=ApiService.getUpComingMovies(Constants.APIKEY)

    suspend fun getLatestMovies()=ApiService.getLatest(Constants.APIKEY)

    suspend fun getTopRatedMovies()=ApiService.getTopRatedMovies(Constants.APIKEY)


}