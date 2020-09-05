package com.grandi.bambino.weatherforeveryday.model.data

import com.grandi.bambino.weatherforeveryday.model.entity.City
import com.grandi.bambino.weatherforeveryday.model.entity.CityResult
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiGeo {

    // @GET("api/v1/cities?locale%5Blang%5D=ru")
    //    fun getCityAsync(@Query("apiKey")apiKey: String) : Deferred<List<City>>
    @GET("api/v1/cities?locale%5Blang%5D=ru&apiKey=pohPiiWfUBXggcg5Iw2JB0W6JEV8aNnC")
    fun getCityAsync() : Deferred<CityResult>

}
