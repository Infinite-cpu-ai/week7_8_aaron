package com.hanzelius.week7_8_aaron.data.repository

import com.hanzelius.week7_8_aaron.data.dto.Weather
import com.hanzelius.week7_8_aaron.data.dto.WeatherItem
import com.hanzelius.week7_8_aaron.data.service.WeatherService
import com.hanzelius.week7_8_aaron.ui.model.WeatherResponse

class WeatherRepository (private val service: WeatherService){

    suspend fun getWeather(city: String): WeatherResponse{
        val weathers = service.getCurrentWeather(
            city = city,
            units = "metric",
            apiKey = "28721bf377af09821541395aa0bcb2ea"
        ).body()!!
        return WeatherResponse(
            cityName = weathers.name,
            currentDate = "",
            updateTime = "",

            iconCondition = weathers.weather[0].icon,
            condition = weathers.weather[0].main,
            temperature = weathers.main.temp,

            humidityPercentage = weathers.main.humidity,
            windSpeed = weathers.wind.speed,
            tempFeelsLike = weathers.main.feels_like,
            rainFall = weathers.rain.`1h`,
            pressure = weathers.main.pressure,
            cloudiness = weathers.clouds.all,

            sunrise = weathers.sys.sunrise,
            sunset = weathers.sys.sunset,

            isError = false,
            errorMessage = ""
        )
    }
    private fun getIconUrl(iconCode: String): String {
        return "https://openweathermap.org/img/wn/${iconCode}@2x.png"
    }
}
