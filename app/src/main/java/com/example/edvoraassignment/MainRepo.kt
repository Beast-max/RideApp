package com.example.edvoraassignment

import com.example.edvoraassignment.Api.ApiCient

class MainRepo {
    val api = ApiCient.api

    suspend fun getUser() = api.getUser()
    suspend fun getRides() = api.getRides()
}