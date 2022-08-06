package com.kishorramani.apicalling.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: CustomAPI by lazy {
        Retrofit.Builder().baseUrl("url")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CustomAPI::class.java)
    }
}