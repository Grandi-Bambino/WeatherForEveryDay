package com.grandi.bambino.weatherforeveryday.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.solver.widgets.Helper
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.grandi.bambino.weatherforeveryday.R
import com.grandi.bambino.weatherforeveryday.model.data.Repository
import com.grandi.bambino.weatherforeveryday.model.data.RetrofitHolder
import com.grandi.bambino.weatherforeveryday.model.entity.Temperature
import com.grandi.bambino.weatherforeveryday.model.entity.WeatherMain
import com.grandi.bambino.weatherforeveryday.utils.getCelsius
import com.grandi.bambino.weatherforeveryday.view.App
import com.grandi.bambino.weatherforeveryday.viewmodel.IWeatherViewModel
import com.grandi.bambino.weatherforeveryday.viewmodel.ModelFactory
import com.grandi.bambino.weatherforeveryday.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.main_weather_fragment.view.*

class WeatherMainFragment : Fragment() {

    companion object{
        const val KEY = "85675fd44050c015cfaec05909597f08"
        private const val CHOOSE_CITY = "choose city"

        fun newInstance(cityName : String?) = WeatherMainFragment().apply {
            arguments = Bundle().apply {
                putString(CHOOSE_CITY, cityName)
            }
        }
    }

    lateinit var viewModel: IWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_weather_fragment, container, false)
        viewModel = ViewModelProvider(requireActivity(), ModelFactory())[WeatherViewModel::class.java]
        viewModel.getWeatherCoroutine(getString(R.string.ru, viewModel.getCity().value), KEY)
        viewModel.subscribeWeather().observe(requireActivity(), Observer {
            init(view, it)
        })
        return view
    }

    private fun init(view: View, weather: Temperature){
        view.tv_main_temperature.text = getCelsius(weather.main.temp).toString()
        view.tv_humidity.text = weather.main.humidity.toString()
        view.tv_pressure.text = weather.main.pressure.toString()
        view.tv_min_temp.text = getCelsius(weather.main.temp).toString()
        view.tv_max_temp.text = getCelsius(weather.main.temp).toString()
        view.tv_description.text = weather.weather[0].description

    }
}