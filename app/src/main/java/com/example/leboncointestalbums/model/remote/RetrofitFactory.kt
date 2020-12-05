package com.example.leboncointestalbums.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  RetrofitFactory {

    private var retrofit: Retrofit
    private val API_URL = "https://static.leboncoin.fr"


    init {
        retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRetrofit(): Retrofit? {
        return retrofit
    }

}