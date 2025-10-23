package com.hanzelius.week7_8_aaron.data.repository

class WeatherRepository {
    suspend fun getWeather(city: String, apiKey: String): WeatherResponse {
        return RetrofitInstance.api.getWeatherByCity(city, apiKey)
    }
}
