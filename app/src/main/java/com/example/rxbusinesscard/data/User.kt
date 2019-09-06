package com.example.rxbusinesscard.data

import com.google.gson.annotations.SerializedName

data class User(
    @field:SerializedName("id") val id: Int,
    @field:SerializedName("name") val name:String,
    @field:SerializedName("email") val email: String,
    @field:SerializedName("address") val address: Address,
    @field:SerializedName("phone") val phone: String,
    @field:SerializedName("website") val webSite: String,
    @field:SerializedName("company") val company: Company
)