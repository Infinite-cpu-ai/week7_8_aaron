package com.hanzelius.week7_8_aaron.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanzelius.week7_8_aaron.R
import com.hanzelius.week7_8_aaron.data.container.WeatherContainer
import com.hanzelius.week7_8_aaron.data.repository.WeatherRepository
import com.hanzelius.week7_8_aaron.ui.model.WeatherResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    private val _weather = MutableStateFlow(WeatherResponse())
    val weather: StateFlow<WeatherResponse> = _weather

    private val _weatherIconUrl = MutableStateFlow("")
    val weatherIconUrl: StateFlow<String> = _weatherIconUrl

    private val _currentDate = MutableStateFlow("")
    val currentDate: StateFlow<String> = _currentDate

    private val _updateTime = MutableStateFlow("")
    val updateTime: StateFlow<String> = _updateTime

    private val _sunrise = MutableStateFlow("")
    val sunrise: StateFlow<String> = _sunrise

    private val _sunset = MutableStateFlow("")
    val sunset: StateFlow<String> = _sunset

    private fun formatUnixTime(unixSeconds: Int): String {
        val date = Date(unixSeconds * 1000L)
        return SimpleDateFormat("h:mm a", Locale.getDefault()).format(date)
    }
    fun formatTime(unixSeconds: Long): String {
        val date = Date(unixSeconds * 1000L)
        val sdf = SimpleDateFormat("h:mm a", Locale.getDefault())
        return sdf.format(date)
    }

    val formattedUpdateTime = formatTime(System.currentTimeMillis() / 1000)
    val weatherResponse = WeatherResponse(
        updateTime = formattedUpdateTime
    )

    fun getWeatherTriples(weather: WeatherResponse): List<Triple<Int, String, String>> {
        return listOf(
            Triple(R.drawable.icon_humidity, "Humidity", "${weather.humidityPercentage}%"),
            Triple(R.drawable.icon_wind, "Wind", "${weather.windSpeed} km/h"),
            Triple(R.drawable.icon_feels_like, "Feels Like", "${weather.tempFeelsLike}°"),
            Triple(R.drawable.vector_2, "Rainfall", "${weather.rainFall} mm"),
            Triple(R.drawable.devices, "Pressure", "${weather.pressure} hPa"),
            Triple(R.drawable.cloud, "Clouds", "${weather.cloudiness}%")
        )
    }


    fun loadWeather(city: String) {
        viewModelScope.launch {
            _weather.value = _weather.value.copy(
                isError = false,
                errorMessage = null
            )

            try {
                val repo = WeatherContainer().weatherRepository
                val result = repo.getWeather(city)

                val dateFormatter = SimpleDateFormat("MMMM dd", Locale.getDefault())
                val timeFormatter = SimpleDateFormat("h:mm a", Locale.getDefault())
                val now = Date()

                _currentDate.value = dateFormatter.format(now)
                _updateTime.value = "Updated as of ${timeFormatter.format(now)}"
                _sunrise.value = formatUnixTime(result.sunrise)
                _sunset.value = formatUnixTime(result.sunset)

                _weather.value = result.copy(
                    currentDate = _currentDate.value,
                    updateTime = _updateTime.value,
                    isError = false,
                    errorMessage = null
                )

                _weatherIconUrl.value = repo.getIconUrl(result.iconCondition ?: "").url

            } catch (e: Exception) {
                _weather.value = WeatherResponse(
                    isError = true,
                    errorMessage = "HTTP 404 Not Found"
                )
            }
        }
    }
}
