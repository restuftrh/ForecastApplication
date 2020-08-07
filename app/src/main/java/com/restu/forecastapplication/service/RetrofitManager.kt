package com.restu.forecastapplication.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {

    val apiService: WeatherService

    init {

        val client = OkHttpClient.Builder().build()

        apiService = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(WeatherService::class.java)
    }


}