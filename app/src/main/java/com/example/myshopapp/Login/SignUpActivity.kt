package com.example.myshopapp.Login

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myshopapp.Api.APIService
import com.example.myshopapp.Api.ApiUtils
import com.example.myshopapp.Models.UserModel
import com.example.myshopapp.R
import com.google.gson.JsonElement
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
    private var apiService: APIService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        apiService = ApiUtils.getAPIService()
    }

    fun btnSignUpOnClick(view: View) {
        if (etUserEmailActivitySignUp!!.text.isNotEmpty() && etUserNickNameSignUpActivity!!.text.isNotEmpty()
            && etUserNameActivitySignUp!!.text.isNotEmpty() && etUserPasswordActivitySignUp!!.text.isNotEmpty()){
            var userModel = UserModel()
            userModel.UserName = etUserNameActivitySignUp!!.text.toString().split(" ")[0]
            userModel.UserSurname = etUserNameActivitySignUp!!.text.toString().split(" ").get(etUserNameActivitySignUp!!.text.toString().split(" ").lastIndex)
            userModel.EMail = etUserEmailActivitySignUp!!.text.toString()
            userModel.Password = etUserPasswordActivitySignUp!!.text.toString()
            userModel.PhoneNumber = "00000000"

            apiService!!.userRegister(userModel).enqueue(object : Callback<JsonElement>{
                override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                    if (response.isSuccessful){
                        response.body()
                    }
                }

                override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                    Log.e("userRegister",t.message)
                }

            })

        }





    }
    fun btnCancelOnClick(view: View) {
        onBackPressed()
    }
    fun isEmailValid(email: String?): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }
}