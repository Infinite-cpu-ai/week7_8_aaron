package com.hanzelius.week7_8_aaron.data.container

import com.google.gson.GsonBuilder
import com.hanzelius.week7_8_aaron.data.service.WeatherService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherContainer {

    companion object{
        val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: WeatherService by lazy {
        retrofit.create(WeatherService::class.java)
    }
}