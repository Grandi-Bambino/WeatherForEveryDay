package com.grandi.bambino.weatherforeveryday.model.data

import androidx.lifecycle.LiveData

interface IRepository<T, Y> {

    suspend fun getWeather(city: String, key: String) : T
    suspend fun getCity() : Y


    fun subscribeLiveDataTemperature() : LiveData<T>
    fun subscribeLiveDataCity() : LiveData<Y>


}