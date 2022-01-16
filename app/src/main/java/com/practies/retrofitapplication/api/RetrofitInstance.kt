package com.practies.retrofitapplication.api

import android.provider.Telephony.TextBasedSmsColumns.BODY
import com.practies.retrofitapplication.BuildConfig
import com.practies.retrofitapplication.helper.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.logging.Level

class RetrofitInstance {


    fun<Api> buildApi(
        api: Class<Api>
    ):Api{

        return   Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }






}