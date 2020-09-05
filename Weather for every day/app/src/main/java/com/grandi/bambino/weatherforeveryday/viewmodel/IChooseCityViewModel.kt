package com.grandi.bambino.weatherforeveryday.viewmodel

import androidx.lifecycle.LiveData
import com.grandi.bambino.weatherforeveryday.model.entity.City
import com.grandi.bambino.weatherforeveryday.model.entity.CityResult

interface IChooseCityViewModel {

    fun subscribeCity() : LiveData<CityResult>
    fun getCityCoroutines()

}