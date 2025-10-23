package com.hanzelius.week7_8_aaron.data.container

class WeatherContainer {

    companion object{
        val BASE_URL = "https://api.openweathermap.org/data/2.5/"
        val BASE_IMG_URL = "https://openweathermap.org/img/wn/"
        val API_KEY = ""
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor {AuthInterceptor(API_KEY)}
        .build()
}