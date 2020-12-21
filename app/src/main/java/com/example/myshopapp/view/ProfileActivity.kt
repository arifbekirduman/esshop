package com.example.myshopapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myshopapp.R
import com.example.myshopapp.utils.BottomNavigationViewHelper
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    private var ACTIVITY_NO = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        init()
    }

    private fun init() {
        BottomNavigationViewHelper.setupBottomNavigationView(
            this,
            bottomNavigationViewProfileActivity
        )
        val menu = bottomNavigationViewProfileActivity!!.menu
        val menuItem = menu.getItem(ACTIVITY_NO)
        menuItem.isChecked = true
    }
}