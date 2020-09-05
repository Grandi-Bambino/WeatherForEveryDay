package com.grandi.bambino.weatherforeveryday.viewmodel

import androidx.lifecycle.ViewModel
import com.grandi.bambino.weatherforeveryday.view.navigation.Screens
import ru.terrakok.cicerone.Router

class MainViewModel(private val router: Router) : ViewModel() {

    fun showChooseCityFragment() {
        router.replaceScreen(Screens.ChooseCityScreen())
    }

}