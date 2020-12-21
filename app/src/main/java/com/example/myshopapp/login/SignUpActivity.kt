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
import com.example.myshopapp.api.APIService
import com.example.myshopapp.api.ApiUtils
import com.example.myshopapp.databinding.ActivitySignUpBinding
import com.example.myshopapp.listener.AuthListener
import com.example.myshopapp.view.HomeActivity
import com.example.myshopapp.viewmodel.AuthViewModel
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity(), AuthListener {
    private var apiService: APIService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySignUpBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        var viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.registerViewModel = viewModel
        viewModel.authListener = this


        apiService = ApiUtils.getAPIService()
    }

    override fun onStarted() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        progressBar.visibility = View.GONE
        loginResponse.observe(this, Observer {
            if (it != null && it == "Created") {
                Log.e("gelenDeger", it)
                startActivity(
                    Intent(
                        this,
                        HomeActivity::class.java
                    ).setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                )
            } else {
                Log.e("gelenDegerErr", "err")
            }
        })
    }

    override fun onFailure(message: String) {
        progressBar.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onDenied() {
        onBackPressed()
    }
}