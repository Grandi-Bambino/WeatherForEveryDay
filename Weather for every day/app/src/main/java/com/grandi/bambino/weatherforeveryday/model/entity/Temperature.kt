package com.grandi.bambino.weatherforeveryday.model.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Temperature(
    @field:SerializedName("main")
    val main: WeatherMain,
    @field:SerializedName("list")
    val list: List<Weathers>,
    @field:SerializedName("wind")
    val wind: Wind,
    @field:SerializedName("weather")
    val weather: List<Weather>
): Parcelable {
}