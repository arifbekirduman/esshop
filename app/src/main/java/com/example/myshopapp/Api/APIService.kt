package com.example.myshopapp.Api

import com.example.myshopapp.Models.UserModel
import com.google.gson.JsonElement
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.Call
import retrofit2.http.Body

interface APIService {

    @POST("/api/auth/register")
    fun userRegister(@Body user : UserModel) : Call<JsonElement>




}