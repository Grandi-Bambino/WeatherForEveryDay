package com.grandi.bambino.weatherforeveryday.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.terrakok.cicerone.Router

class ModelFactory() : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            WeatherViewModel::javaClass -> WeatherViewModel() as T
            ChooseCityViewModel::javaClass -> ChooseCityViewModel() as T
            else -> super.create(modelClass)
        }
    }
}