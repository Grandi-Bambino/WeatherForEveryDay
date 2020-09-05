package com.grandi.bambino.weatherforeveryday.utils



fun getCelsius(fahrenheit: Double) : Int{
    val celsius = fahrenheit - 273.15
    return celsius.toInt()
}

const val API_GEO_HELPER ="pohPiiWfUBXggcg5Iw2JB0W6JEV8aNnC"