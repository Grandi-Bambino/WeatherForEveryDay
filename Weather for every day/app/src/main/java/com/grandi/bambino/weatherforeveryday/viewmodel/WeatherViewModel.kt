package com.grandi.bambino.weatherforeveryday.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.grandi.bambino.weatherforeveryday.model.data.IRepository
import com.grandi.bambino.weatherforeveryday.model.data.Repository
import com.grandi.bambino.weatherforeveryday.model.data.RetrofitHolder
import com.grandi.bambino.weatherforeveryday.model.entity.City
import com.grandi.bambino.weatherforeveryday.model.entity.CityResult
import com.grandi.bambino.weatherforeveryday.model.entity.Temperature
import kotlinx.coroutines.*
import com.grandi.bambino.weatherforeveryday.model.entity.WeatherMain
import com.grandi.bambino.weatherforeveryday.view.App
import com.grandi.bambino.weatherforeveryday.view.navigation.Screens
import ru.terrakok.cicerone.Router

class WeatherViewModel(
    private val router: Router = App.instance.getRouter(),
    private val repository: IRepository<Temperature, CityResult> = Repository(RetrofitHolder()),
    private val liveData: MutableLiveData<Temperature> = MutableLiveData(),
    private val liveDataCity: MutableLiveData<String> = MutableLiveData()
) : ViewModel(), IWeatherViewModel {

    private val observerGetTemperature = Observer<Temperature>{
        liveData.postValue(it)
    }

    init {
        repository.subscribeLiveDataTemperature().observeForever(observerGetTemperature)
    }

    override fun subscribeWeather() = liveData
    override fun selectCity(city: String) {
        liveDataCity.postValue(city)
    }

    override fun getCity() = liveDataCity


    private val weatherViewModelCoroutinesScope = CoroutineScope(
        Dispatchers.Main + SupervisorJob()
    )


    override fun onCleared() {
        super.onCleared()
        repository.subscribeLiveDataTemperature().removeObserver(observerGetTemperature)
        cancelJob()
    }

    private fun cancelJob() {
        weatherViewModelCoroutinesScope.coroutineContext.cancelChildren()
    }

    private suspend fun getWeather(city: String, key: String) = withContext(Dispatchers.IO){
        repository.getWeather(city, key)
    }

    override fun getWeatherCoroutine(city: String, key: String){
        cancelJob()
        weatherViewModelCoroutinesScope.launch { getWeather(city, key) }
    }

    override fun showWeatherMain(){
        router.replaceScreen(Screens.WeatherMainScreen(null))
    }

}