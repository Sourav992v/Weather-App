package com.sourav.weatherapp.data

data class WeatherEntity(
    val time: Long,
    val summary: String,
    val icon: String,
    val temperature: Double,
    val temperatureHigh: Double,
    val apparentTemperature: Double,
    val apparentTemperatureHigh: Double
) {
}