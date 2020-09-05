package com.grandi.bambino.weatherforeveryday.model.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weather (
    @field:SerializedName("main")
    val main: String,
    @field:SerializedName("description")
    val description: String
): Parcelable