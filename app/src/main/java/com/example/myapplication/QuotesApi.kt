package com.example.myapplication

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {
    @GET("apod?api_key=DEMO_KEY")
    suspend fun getQuotes() : Response<Apod>
}