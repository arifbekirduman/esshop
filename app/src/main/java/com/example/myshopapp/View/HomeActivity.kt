package com.example.myshopapp.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myshopapp.Adapter.HomePagerAdapter
import com.example.myshopapp.R
import com.example.myshopapp.Utils.BottomNavigationViewHelper
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private var ACTIVITY_NO = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()
        setupPagerAdapter()
    }

    private fun setupPagerAdapter() {
        viewPagerHomeActivity.adapter = HomePagerAdapter(this)

        TabLayoutMediator(
            tabLayoutHomeActivity, viewPagerHomeActivity
        ) { tab, position ->
            when (position) {
                0 -> tab.text = "Erkek Giyim"
                1 -> tab.text = "Kadın Giyim"
            }
        }.attach()
    }

    private fun init() {
        BottomNavigationViewHelper.setupBottomNavigationView(
            this,
            bottomNavigationViewHomeActivity
        )
        val menu = bottomNavigationViewHomeActivity!!.menu
        val menuItem = menu.getItem(ACTIVITY_NO)
        menuItem.isChecked = true


    }
}