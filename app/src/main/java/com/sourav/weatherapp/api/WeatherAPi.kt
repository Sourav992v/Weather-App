package com.sourav.weatherapp.api

import retrofit2.http.GET

//Created on 22 April 2021 by Sourav

interface WeatherAPi {

    companion object{
        const val BASE_URL = "https://api.darksky.net/forecast/"
    }

    @GET("9d35d1a7a8886a7edb859486944c9036/48.44,80.44")
    suspend fun getWeather(): WeatherResponse
}