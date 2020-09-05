package com.grandi.bambino.weatherforeveryday.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.grandi.bambino.weatherforeveryday.R
import com.grandi.bambino.weatherforeveryday.model.entity.City
import com.grandi.bambino.weatherforeveryday.model.entity.CityResult
import com.grandi.bambino.weatherforeveryday.utils.API_GEO_HELPER
import com.grandi.bambino.weatherforeveryday.view.App
import com.grandi.bambino.weatherforeveryday.viewmodel.ChooseCityViewModel
import com.grandi.bambino.weatherforeveryday.viewmodel.IWeatherViewModel
import com.grandi.bambino.weatherforeveryday.viewmodel.ModelFactory
import com.grandi.bambino.weatherforeveryday.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.choose_city_fragment.*
import kotlinx.android.synthetic.main.choose_city_fragment.view.*

class ChooseCityFragment : Fragment() {

    companion object{
        fun newInstance() = ChooseCityFragment()
    }
    
    lateinit var viewModel: IWeatherViewModel
    lateinit var adapterDropdownMenu : ArrayAdapter<String>

    var cities = arrayOf<String>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.choose_city_fragment, container, false)
        cities = requireContext().resources.getStringArray(R.array.cities)
        viewModel = ViewModelProvider(requireActivity(), ModelFactory())[WeatherViewModel::class.java]

        adapterDropdownMenu = ArrayAdapter(requireContext(), R.layout.support_simple_spinner_dropdown_item,  cities)
        (view.choose_city as? AutoCompleteTextView)?.setAdapter(adapterDropdownMenu)

        view.btn_choose.setOnClickListener {
            viewModel.selectCity(view.choose_city.text.toString())
            viewModel.showWeatherMain()
        }
        
        return view
    }

    //TODO не работает(разобраться с api)
    private fun initDropdownMenu(cities: CityResult) : MutableList<String>{

        val citiesString = mutableListOf<String>()
        citiesString.add(cities.result.name)
        return  citiesString
    }

}