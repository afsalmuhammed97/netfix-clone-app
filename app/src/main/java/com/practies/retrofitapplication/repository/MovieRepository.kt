package com.practies.retrofitapplication.repository

import com.practies.retrofitapplication.api.ApiService
import com.practies.retrofitapplication.helper.Constants
import javax.inject.Inject

class MovieRepository
@Inject
constructor( private val ApiService: ApiService){


    suspend fun getPopularMovies()=ApiService.getPopularMovies(Constants.APIKEY)
}