package com.practies.retrofitapplication.api.dataBase

import androidx.paging.ExperimentalPagingApi
import com.practies.retrofitapplication.Movie
import com.practies.retrofitapplication.api.ApiService
@OptIn(ExperimentalPagingApi::class)

class RemoteMediator(private val apiService: ApiService, private val movieDbEntity: MovieDbEntity
<Int,Movie>(){

    val movieDao=movieDbEntity.movieDao()

}