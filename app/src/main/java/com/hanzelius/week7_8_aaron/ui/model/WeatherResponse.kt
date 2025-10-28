package com.hanzelius.week7_8_aaron.ui.model

data class WeatherResponse(
    val cityName: String? = null,
    val currentDate: Int = 0,

    val iconCondition: String? = null,
    val condition: String? = null,
    val temperature: Double = 0.0,

    val humidityPercentage: Int = 0,
    val windSpeed: Double = 0.0,
    val tempFeelsLike: Double = 0.0,
    val rainFall: Double = 0.0,
    val pressure: Int = 0,
    val cloudiness: Int = 0,

    val sunrise: Int = 0,
    val sunset: Int = 0,

    val isError: Boolean = false,
    val errorMessage: String? = null
)
