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
import com.grandi.bambino.weatherforeveryday.view.App
import com.grandi.bambino.weatherforeveryday.view.navigation.Screens
import kotlinx.coroutines.*
import ru.terrakok.cicerone.Router

class ChooseCityViewModel (
    private val router: Router = App.instance.getRouter(),
    private val repository: IRepository<Temperature, CityResult> = Repository(RetrofitHolder()),
    private val liveData: MutableLiveData<CityResult> = MutableLiveData()
    ) : ViewModel(), IChooseCityViewModel {

    private val observerGetCity = Observer<CityResult>{
        liveData.postValue(it)
    }

    init {
        repository.subscribeLiveDataCity().observeForever(observerGetCity)
    }

    override fun subscribeCity() = liveData

    private val cityViewModelCoroutinesScope = CoroutineScope(
        Dispatchers.Main + SupervisorJob()
    )

    override fun onCleared() {
        super.onCleared()
        repository.subscribeLiveDataCity().removeObserver(observerGetCity)
        cancelJob()
    }

    private fun cancelJob() {
        cityViewModelCoroutinesScope.coroutineContext.cancelChildren()
    }

    private suspend fun getCity() = withContext(Dispatchers.IO){
        repository.getCity()
    }

    override fun getCityCoroutines() {
        cityViewModelCoroutinesScope.launch {
            cancelJob()
            getCity()
        }
    }

    fun setCityName(cityName: String) : String{
        return cityName
    }

    fun showWeatherMain(){
        router.replaceScreen(Screens.WeatherMainScreen(null))
    }



}