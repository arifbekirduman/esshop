package com.example.myshopapp.listener

import androidx.lifecycle.LiveData

interface AuthListener {
    fun onStarted()
    fun onSuccess(loginResponse:LiveData<String>)
    fun onFailure(message:String)
    fun onDenied()
}