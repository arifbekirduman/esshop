package com.example.myshopapp.api

class ApiUtils {
    private fun ApiUtils() {}


 companion object{
        val BASE_URL = "http://192.168.8.101:5001"
        fun getAPIService(): APIService? {
            return RetrofitClient().getClient(BASE_URL)!!.create(APIService::class.java)
        }
    }


}