package com.example.myshopapp.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String?): Retrofit? {
        if (retrofit == null) {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
        return retrofit
    }
}