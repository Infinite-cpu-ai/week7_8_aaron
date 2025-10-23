package com.hanzelius.week7_8_aaron.ui.model

data class WeatherResponse(
    val cityName: String,
    val currentDate: String,
    val updateTime: String,

    val iconCondition: String? = null,
    val condition: String,
    val temperature: Double,

    val humidityPercentage: Int,
    val windSpeed: Double,
    val tempFeelsLike: Double,
    val rain_fall: Double,
    val pressure: Int,
    val cloudiness: Int,

    val sunrise: Int,
    val sunset: Int,

    val isError: Boolean = false,
    val errorMessage: String = ""
)
