package com.practies.retrofitapplication.api

import com.practies.retrofitapplication.ApiResponse
import com.practies.retrofitapplication.helper.Constants.APIKEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("upcoming?")            //BASE_URL@Query("api_key"
   suspend  fun  getUpComingMovies( @Query("page")page:Int,@Query("api_key")key:String =APIKEY):Response <ApiResponse>

   @GET("popular?")
   suspend fun getPopularMovies(@Query("api_key")key:String=APIKEY):Response<ApiResponse>




   @GET("top_rated?")
   suspend fun getTopRatedMovies(@Query("api_key")key: String=APIKEY):Response<ApiResponse>

    @GET("now_playing?")
    suspend fun getNowPlaying(@Query("api_key")key: String =APIKEY):Response<ApiResponse>

//    @GET("latest?")
//    suspend fun getLatest(@Query("api_key")key: String =APIKEY):Response<ApiResponse>



}

///e4bbe4d35eb4b28c8b0083304f7b662f

///  https://api.themoviedb.org/3/movie/upcoming?api_key=e4bbe4d35eb4b28c8b0083304f7b662f&language=en-US&page=1
// fun getMovies(@Query("api_key") key: String): Call<PopularMovies>
//example
//https://api.themoviedb.org/3/movie/550?api_key=e4bbe4d35eb4b28c8b0083304f7b662f