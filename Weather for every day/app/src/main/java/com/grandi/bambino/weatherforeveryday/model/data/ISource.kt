package com.grandi.bambino.weatherforeveryday.model.data

import com.grandi.bambino.weatherforeveryday.model.entity.City
import com.grandi.bambino.weatherforeveryday.model.entity.CityResult
import com.grandi.bambino.weatherforeveryday.model.entity.Temperature

interface ISource {

    suspend fun getWeather(city: String, key: String) : Temperature

    suspend fun getCity() : CityResult
}