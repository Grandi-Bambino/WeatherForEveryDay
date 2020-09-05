package com.grandi.bambino.weatherforeveryday.model.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class City(
    @field:SerializedName("name")
    val name: String
): Parcelable
