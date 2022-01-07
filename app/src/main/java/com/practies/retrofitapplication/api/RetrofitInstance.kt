package com.practies.retrofitapplication.api

import com.practies.retrofitapplication.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }



    val api:MovieDb by lazy {

          retrofit.create(MovieDb::class.java)

    }





}