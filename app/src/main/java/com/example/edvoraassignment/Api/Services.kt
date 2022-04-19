package com.example.edvoraassignment.Api

import com.example.edvoraassignment.Model.RideResponse
import com.example.edvoraassignment.Model.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface Services {
    @GET("user")
    suspend fun getUser():Response<UserResponse>

    @GET("rides")
    suspend fun getRides():Response<RideResponse>
}