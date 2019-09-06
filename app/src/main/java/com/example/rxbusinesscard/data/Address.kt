package com.example.rxbusinesscard.data

import com.google.gson.annotations.SerializedName

data class Address(
    @field:SerializedName("street") val street: String,
    @field:SerializedName("suite") val suite:String,
    @field:SerializedName("city") val city: String,
    @field:SerializedName("zipcode") val zipCode: String,
    @field:SerializedName("geo") val geo: Geo
)
