package com.grandi.bambino.weatherforeveryday.viewmodel

import androidx.lifecycle.LiveData
import com.grandi.bambino.weatherforeveryday.model.entity.Temperature
import com.grandi.bambino.weatherforeveryday.model.entity.WeatherMain

interface IWeatherViewModel {

    fun getWeatherCoroutine(city: String, key: String)
    fun subscribeWeather() : LiveData<Temperature>

    fun selectCity(city: String)
    fun getCity() : LiveData<String>

    fun showWeatherMain()

}