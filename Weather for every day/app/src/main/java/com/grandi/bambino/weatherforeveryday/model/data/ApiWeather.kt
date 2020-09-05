package com.grandi.bambino.weatherforeveryday.model.data

import com.grandi.bambino.weatherforeveryday.model.entity.Temperature
import com.grandi.bambino.weatherforeveryday.model.entity.WeatherMain
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiWeather {

    @GET("data/2.5/weather")
    fun searchCityAsync(@Query("q")q: String, @Query("appid")key: String, @Query("lang")lang : String = "ru") : Deferred<Temperature>
}