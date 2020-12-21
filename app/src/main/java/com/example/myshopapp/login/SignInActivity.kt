package com.example.myshopapp.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myshopapp.R
import com.example.myshopapp.databinding.ActivitySignInBinding
import com.example.myshopapp.listener.AuthListener
import com.example.myshopapp.view.HomeActivity
import com.example.myshopapp.viewmodel.AuthViewModel
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity(), AuthListener {
    lateinit var viewModel:AuthViewModel
    lateinit var activitySignInBinding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySignInBinding = DataBindingUtil.setContentView(this,R.layout.activity_sign_in)

        init()
    }

    private fun init() {
        viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        activitySignInBinding.loginViewModel = viewModel
        viewModel.authListener = this
    }

    fun forgetMyPasswordOnClick(view: View) {}
    fun userRegisterOnClick(view: View) {
        startActivity(Intent(this, SignUpActivity::class.java))
    }

    override fun onStarted() {
        progressBarSignInActivitiy.visibility = View.VISIBLE
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            progressBarSignInActivitiy.visibility = View.GONE
            if (it != null){
                Log.e("userLoginSuccess",it)
                startActivity(Intent(this,HomeActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
            }else{
                Toast.makeText(this,"UserName/Password Invalid",Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onFailure(message: String) {
        progressBarSignInActivitiy.visibility = View.GONE
    }

    override fun onDenied() {
    }

}