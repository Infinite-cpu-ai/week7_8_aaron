package com.hanzelius.week7_8_aaron.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanzelius.week7_8_aaron.R
import com.hanzelius.week7_8_aaron.data.container.WeatherContainer
import com.hanzelius.week7_8_aaron.data.dto.WeatherItem
import com.hanzelius.week7_8_aaron.data.repository.WeatherRepository
import com.hanzelius.week7_8_aaron.ui.model.WeatherResponse
import kotlinx.coroutines.launch
import okhttp3.Response


class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    private val _weather = MutableLiveData<WeatherResponse>()
    val weather: LiveData<WeatherResponse> = _weather

    val listDetail = arrayListOf(
        arrayListOf(R.drawable.icon_humidity, "HUMIDITY", "${weather.value.humidityPercentage}%"),
        arrayListOf(R.drawable.icon_wind, "WIND SPEED", "${weather.value.windSpeed} m/s"),
        arrayListOf(R.drawable.icon_feels_like, "FEELS LIKE", "${weather.value.tempFeelsLike}°C"),
        arrayListOf(R.drawable.vector_2, "RAIN FALL", "${weather.value.rainFall} mm"),
        arrayListOf(R.drawable.devices, "PRESSURE", "${weather.value.pressure}hPa"),
        arrayListOf(R.drawable.cloud, "CLOUDINESS", "${weather.value.cloudiness}%")
    )

}
