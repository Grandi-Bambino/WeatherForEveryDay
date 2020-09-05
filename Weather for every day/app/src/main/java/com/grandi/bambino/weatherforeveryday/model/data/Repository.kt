package com.grandi.bambino.weatherforeveryday.model.data

import androidx.lifecycle.MutableLiveData
import com.grandi.bambino.weatherforeveryday.model.entity.City
import com.grandi.bambino.weatherforeveryday.model.entity.CityResult
import com.grandi.bambino.weatherforeveryday.model.entity.Temperature

class Repository(private val remoteSource: ISource) : IRepository<Temperature, CityResult> {

    private val liveDataTemperature:MutableLiveData<Temperature> = MutableLiveData()
    private val liveDataCity: MutableLiveData<CityResult> = MutableLiveData()

    override suspend fun getWeather(city: String, key: String): Temperature {
        liveDataTemperature.postValue(remoteSource.getWeather(city, key))
        return remoteSource.getWeather(city, key)
    }

    override suspend fun getCity(): CityResult {
        liveDataCity.postValue(remoteSource.getCity())
        return remoteSource.getCity()
    }

    override fun subscribeLiveDataTemperature() = liveDataTemperature
    override fun subscribeLiveDataCity() = liveDataCity

}