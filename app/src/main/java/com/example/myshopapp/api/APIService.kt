package com.example.myshopapp.api

import com.example.myshopapp.response.ProductResponse
import com.example.myshopapp.models.UserModel
import com.example.myshopapp.response.CategoryResponse
import retrofit2.Call
import retrofit2.http.*

interface APIService {

    @POST("/api/auth/register")
    fun userRegister(@Body user : UserModel) : Call<kotlin.String>

    @POST("/api/auth/login")
    fun loginUser(@Body user : UserModel) : Call<String>

    @GET("/api/products")
    fun getProduct() : Call<ProductResponse>

    @GET("/api/products/getByCategory/{id}")
    fun getByCategory(@Path("id") id : Int) : Call<ProductResponse>

    @GET("/api/category")
    fun getCategory():Call<CategoryResponse>




}