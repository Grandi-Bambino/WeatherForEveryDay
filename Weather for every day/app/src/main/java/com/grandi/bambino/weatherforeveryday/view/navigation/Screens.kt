package com.grandi.bambino.weatherforeveryday.view.navigation

import com.grandi.bambino.weatherforeveryday.view.fragments.ChooseCityFragment
import com.grandi.bambino.weatherforeveryday.view.fragments.WeatherMainFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class ChooseCityScreen() : SupportAppScreen(){
        override fun getFragment() = ChooseCityFragment.newInstance()
    }

    class WeatherMainScreen(private val cityName: String?) : SupportAppScreen(){
        override fun getFragment() = WeatherMainFragment.newInstance(cityName)
    }


}