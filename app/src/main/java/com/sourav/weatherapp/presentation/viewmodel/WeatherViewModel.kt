package com.sourav.weatherapp.presentation.viewmodel

import androidx.lifecycle.*
import com.sourav.weatherapp.api.WeatherAPi
import com.sourav.weatherapp.data.WeatherEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


//Created on 22 April 2021 by Sourav

@HiltViewModel
class WeatherViewModel @Inject constructor(
    api: WeatherAPi
): ViewModel(){

    private val hourlyLiveData = MutableLiveData<List<WeatherEntity>>()
    private val dailyLiveData = MutableLiveData<List<WeatherEntity>>()

    val hourly: LiveData<List<WeatherEntity>> = hourlyLiveData
    val daily: LiveData<List<WeatherEntity>> = dailyLiveData

    init {
        viewModelScope.launch {
            val weather = api.getWeather()
            hourlyLiveData.value = weather.hourly.data
            dailyLiveData.value = weather.daily.data
        }
    }
}