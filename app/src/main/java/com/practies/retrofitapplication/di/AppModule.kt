package com.practies.retrofitapplication.di

import com.practies.retrofitapplication.api.ApiService
import com.practies.retrofitapplication.helper.Constants.BASE_URL
import com.practies.retrofitapplication.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

@Singleton
@Provides
fun providesRetrofit():Retrofit=
                Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()


    @Singleton
    @Provides
    fun providesAPI(retrofit: Retrofit):ApiService=
                    retrofit.create(ApiService::class.java)


    @Singleton
    @Provides
    fun providesRepository(apiService: ApiService)=MovieRepository(apiService)

}