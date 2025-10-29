package com.hanzelius.week7_8_aaron.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanzelius.week7_8_aaron.R
import com.hanzelius.week7_8_aaron.data.container.WeatherContainer
import com.hanzelius.week7_8_aaron.ui.model.WeatherResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class WeatherViewModel : ViewModel() {
    private val _weather = MutableStateFlow(WeatherResponse())
    val weather: StateFlow<WeatherResponse> = _weather
    private val _weatherIconUrl = MutableStateFlow("")
    val weatherIconUrl: StateFlow<String> = _weatherIconUrl
    val currentDate: StateFlow<String> = weather.map { weatherResponse ->
        SimpleDateFormat("MMMM dd", Locale("id")).format(Date(weatherResponse.currentDate * 1000L))
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = ""
    )
    val updateTime: StateFlow<String> = weather.map { weatherResponse ->
        SimpleDateFormat("h:mm a", Locale("id")).format(Date(weatherResponse.currentDate * 1000L))
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = ""
    )
    val sunset: StateFlow<String> = weather.map { weatherResponse ->
        SimpleDateFormat("h:mm a", Locale("id")).format(Date(weatherResponse.sunset * 1000L))
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = ""
    )
    val sunrise: StateFlow<String> = weather.map { weatherResponse ->
        SimpleDateFormat("h:mm a", Locale("id")).format(Date(weatherResponse.sunrise * 1000L))
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = ""
    )
    fun getWeatherTriples(weather: WeatherResponse): List<Triple<Int, String, String>> {
        return listOf(
            Triple(R.drawable.icon_humidity, "HUMIDITY", "${weather.humidityPercentage}%"),
            Triple(R.drawable.icon_wind, "WIND", "${weather.windSpeed} km/h"),
            Triple(R.drawable.icon_feels_like, "FEELS LIKE", "${weather.tempFeelsLike.toInt()}°"),
            Triple(R.drawable.vector_2, "RAINFALL", "${weather.rainFall} mm"),
            Triple(R.drawable.devices, "PRESSURE", "${weather.pressure} hPa"),
            Triple(R.drawable.cloud, "CLOUDS", "${weather.cloudiness}%")
        )
    }
    val setrise = combine(sunrise, sunset) { sunrise, sunset ->
        listOf(
            Triple(R.drawable.vector, "SUNRISE", sunrise),
            Triple(R.drawable.vector_21png, "SUNSET", sunset)
        )
    }.stateIn(
        viewModelScope, started = SharingStarted.Eagerly,
        initialValue = emptyList()
    )
    val query = MutableStateFlow("")
    fun onQueryChange(newValue: String) {
        query.value = newValue

    }
    fun search() {
        val q = query.value.trim()
        if (q.isNotEmpty()) {
            loadWeather(q)
        } else {
            _weather.value = WeatherResponse()
            _weatherIconUrl.value = ""
        }
    }
    fun loadWeather(city: String) {
        viewModelScope.launch {
            _weather.value = _weather.value.copy(
                isError = false,
                errorMessage = null
            )

            try {
                val result = WeatherContainer().weatherRepository.getWeather(city)


                _weather.value = result.copy(
                    isError = false,
                    errorMessage = null
                )

                _weatherIconUrl.value = WeatherContainer().weatherRepository.getIconUrl(result.iconCondition ?: "").url

            } catch (e: Exception) {
                _weather.value = _weather.value.copy(
                    isError = true,
                    errorMessage = "HTTP 404 Not Found"
                )
                _weatherIconUrl.value = ""
            }
        }
    }
}
