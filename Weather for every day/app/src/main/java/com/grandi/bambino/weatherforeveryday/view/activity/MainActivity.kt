package com.grandi.bambino.weatherforeveryday.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grandi.bambino.weatherforeveryday.R
import com.grandi.bambino.weatherforeveryday.view.App
import com.grandi.bambino.weatherforeveryday.viewmodel.MainViewModel
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    val navigator = SupportAppNavigator(this, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel(App.instance.getRouter())
        mainViewModel.showChooseCityFragment()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.getNavigation().setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.getNavigation().removeNavigator()
    }
}