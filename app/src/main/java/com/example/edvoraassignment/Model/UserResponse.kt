package com.example.edvoraassignment.Model


import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("station_code")
    val stationCode: Int,
    @SerializedName("url")
    val url: String
)