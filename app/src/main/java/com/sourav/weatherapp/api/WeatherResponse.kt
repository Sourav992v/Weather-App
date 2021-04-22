package com.sourav.weatherapp.api

import com.sourav.weatherapp.data.Daily
import com.sourav.weatherapp.data.Hourly

//Created on 22 April 2021 by Sourav

class WeatherResponse(
    val latitude: Double,
    val longitude: Double,
    val hourly: Hourly,
    val daily: Daily
)