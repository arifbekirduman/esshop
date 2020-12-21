package com.example.myshopapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myshopapp.api.APIService
import com.example.myshopapp.api.ApiUtils
import com.example.myshopapp.models.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository {
    private var apiService :APIService

    init {
        apiService = ApiUtils.getAPIService()!!
    }

    fun userLogin(user:UserModel) : LiveData<String>{
        val loginResponse  = MutableLiveData<String>()

        apiService.loginUser(user).enqueue(object : Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                loginResponse.value = response.body().toString()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e("TVShowDetailsRepoEr", t.message)
            }

        })

        return loginResponse
    }

    fun userRegister(user:UserModel) : LiveData<String>{
        val registerResponse = MutableLiveData<String>()

        apiService.userRegister(user).enqueue(object  : Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful && response.body() != null){
                    registerResponse.value = response.body()
                    Log.e("userRegister",response.body())
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e("userRegisterErr",t.message)
            }

        })

        return registerResponse
    }

}