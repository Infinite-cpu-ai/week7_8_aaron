package com.hanzelius.week7_8_aaron.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    private val _state = MutableStateFlow<WeatherState>(WeatherState.Empty)
    val state: StateFlow<WeatherState> = _state

    fun fetchWeather(city: String, apiKey: String) {
        viewModelScope.launch {
            try {
                _state.value = WeatherState.Loading
                val response = repository.getWeather(city, apiKey)
                _state.value = WeatherState.Success(response)
            } catch (e: Exception) {
                _state.value = WeatherState.Error("HTTP 404 Not Found")
            }
        }
    }
}

sealed class WeatherState {
    object Empty : WeatherState()
    object Loading : WeatherState()
    data class Success(val data: WeatherResponse) : WeatherState()
    data class Error(val message: String) : WeatherState()
}
