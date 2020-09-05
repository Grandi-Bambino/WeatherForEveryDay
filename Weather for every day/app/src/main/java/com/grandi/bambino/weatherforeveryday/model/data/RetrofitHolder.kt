package com.grandi.bambino.weatherforeveryday.model.data

import com.grandi.bambino.weatherforeveryday.model.entity.City
import com.grandi.bambino.weatherforeveryday.model.entity.CityResult
import com.grandi.bambino.weatherforeveryday.model.entity.Temperature
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHolder : ISource {

    companion object{
        const val BASE_URL_WEATHER = "http://api.openweathermap.org"
        const val BASE_URL_CITY = "http://geohelper.info"
    }

    override suspend fun getWeather(city: String, key: String): Temperature {
        return createRetrofit(BASE_URL_WEATHER).create(ApiWeather::class.java).searchCityAsync(city, key).await()
    }


    override suspend fun getCity(): CityResult {
        return createRetrofit(BASE_URL_CITY).create(ApiGeo::class.java).getCityAsync().await()
    }



    private fun createRetrofit(baseUrl: String): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient())
        .build()
}