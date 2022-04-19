package com.example.edvoraassignment.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiCient {
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://assessment.api.vweb.app/")
        .build()

    val api = retrofit
        .create(Services::class.java)
}