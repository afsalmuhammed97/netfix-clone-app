package com.practies.retrofitapplication

import com.practies.retrofitapplication.api.ApiService
import com.practies.retrofitapplication.helper.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)                                          //ApplicationComponent
object AppModule {

    @Provides
    fun providesBaseUrl()=Constants.BASE_URL

    @Provides
    @Singleton
    fun  providesRetrofitInstance(BASE_URL:String):ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)


}