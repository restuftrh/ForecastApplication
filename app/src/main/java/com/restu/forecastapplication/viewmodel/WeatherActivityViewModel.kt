package com.restu.forecastapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.restu.forecastapplication.model.WeatherRepository

import kotlinx.coroutines.launch

class WeatherActivityViewModel : ViewModel() {

    private val weatherRepository = WeatherRepository()

    val usersSuccessLiveData = weatherRepository.usersSuccessLiveData
    val usersFailureLiveData = weatherRepository.usersFailureLiveData

    fun getWeather(id : String) {
        //this is coroutine viewmodel scope to call suspend fun of repo
        if (id == "1"){
            viewModelScope.launch { weatherRepository.getWeather("jakarta") }
        }else if(id == "2"){
            viewModelScope.launch { weatherRepository.getWeather("bandung") }
        }else if(id == "3"){
            viewModelScope.launch { weatherRepository.getWeather("yogyakarta") }
        }else if(id == "4"){
            viewModelScope.launch { weatherRepository.getWeather("surabaya") }
        }else if(id == "5"){
            viewModelScope.launch { weatherRepository.getWeather("medan") }
        }else if(id == "6"){
            viewModelScope.launch { weatherRepository.getWeather("banjarmasin") }
        }else if(id == "7"){
            viewModelScope.launch { weatherRepository.getWeather("padang") }
        }


    }
}