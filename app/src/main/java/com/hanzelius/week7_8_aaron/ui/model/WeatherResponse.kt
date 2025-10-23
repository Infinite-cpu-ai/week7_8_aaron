package com.hanzelius.week7_8_aaron.ui.model

data class WeatherResponse(
    val weather: List<Weather>,   // Kondisi cuaca (main, desc, icon)
    val main: Main,               // Suhu, humidity, pressure, feels_like
    val wind: Wind,               // Kecepatan angin
    val clouds: Clouds,           // Persentase awan
    val sys: Sys,                 // Sunrise & sunset
    val name: String              // Nama kota
)

data class Weather(
    val main: String,             // "Clouds"
    val description: String,      // "few clouds"
    val icon: String              // "02d"
)

data class Main(
    val temp: Double,             // 302.7 (Kelvin)
    val feels_like: Double,       // 309.21 (Kelvin)
    val pressure: Int,            // 1006
    val humidity: Int             // 79
)

data class Wind(
    val speed: Double             // 2.06
)

data class Clouds(
    val all: Int                  // 20
)

data class Sys(
    val country: String,          // "ID"
    val sunrise: Long,            // 1761169949
    val sunset: Long              // 1761213678
)
