package com.grandi.bambino.weatherforeveryday.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weathers(
    @field:SerializedName("temp")
    val temp: Double,
    @field:SerializedName("feels_like")
    val feelsLike: Double,
    @field:SerializedName("pressure")
    val pressure: Int,
    @field:SerializedName("humidity")
    val humidity: Int,
    @field:SerializedName("temp_min")
    val minTemp: Double,
    @field:SerializedName("temp_max")
    val maxTemp: Double,
    @field:SerializedName("wind")
    val wind: Wind
): Parcelable