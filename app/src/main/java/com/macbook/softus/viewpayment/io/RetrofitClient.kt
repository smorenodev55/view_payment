package com.macbook.softus.viewpayment.io

import com.google.gson.GsonBuilder
import com.macbook.softus.viewpayment.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val  BASE_URL = Constants.URL_BASE

    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(ApiService::class.java)
    }
}