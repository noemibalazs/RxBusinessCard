package com.example.rxbusinesscard.data

import com.google.gson.annotations.SerializedName

data class Geo(
    @field:SerializedName("lat") val lat: String,
    @field:SerializedName("lng") val lbg: String
)
