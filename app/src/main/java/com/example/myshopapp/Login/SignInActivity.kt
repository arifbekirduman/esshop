package com.example.myshopapp.Login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myshopapp.View.HomeActivity
import com.example.myshopapp.R

class SignInActivity : AppCompatActivity(), TextWatcher {
    lateinit var etUserEmailorNick: EditText
    lateinit var etUserPassword:EditText
    var btnLogIn: Button? = null
   // private val apiService: APIService? = null
    private var userEmailorNick: String? = null
    private var userPassword:kotlin.String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        init()
    }

    fun signInUserOnClick(view: View) {
        startActivity(Intent(this, HomeActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
    }
    fun fargotMyPasswordOnClick(view: View) {}
    fun userRegisterOnClick(view: View) {
        startActivity(Intent(this, SignUpActivity::class.java))
    }
    fun init(){
        etUserEmailorNick = findViewById(R.id.et_email)
        etUserPassword = findViewById(R.id.et_password)
        btnLogIn = findViewById(R.id.btnNextSignInActivity)

        etUserEmailorNick.addTextChangedListener(this)
        etUserPassword.addTextChangedListener(this)
    }
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }


    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        val sonuc = count + start
        if (sonuc >= 5 && etUserEmailorNick.getText()
                .toString().length >= 5 && etUserPassword.getText().toString().length >= 8
        ) {
            btnLogIn!!.setEnabled(true)
            btnLogIn!!.setBackgroundColor(resources.getColor(R.color.blue))
        } else {
            btnLogIn!!.setEnabled(false)
            btnLogIn!!.setBackgroundColor(resources.getColor(R.color.lightblue))
        }
    }

    override fun afterTextChanged(s: Editable?) {
    }
}