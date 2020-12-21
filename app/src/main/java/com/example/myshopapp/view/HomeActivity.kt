package com.example.myshopapp.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myshopapp.adapter.HomePagerAdapter
import com.example.myshopapp.R
import com.example.myshopapp.models.CategoryModel
import com.example.myshopapp.utils.BottomNavigationViewHelper
import com.example.myshopapp.viewmodel.ProductViewModel
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private var ACTIVITY_NO = 0

    lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()
        setupPagerAdapter()

        viewModel.getProductById(2).observe(this, Observer {
            Log.e("product2", it.data.size.toString())
        })
    }

    private fun setupPagerAdapter() {
        viewPagerHomeActivity.adapter = HomePagerAdapter(this)

        TabLayoutMediator(
            tabLayoutHomeActivity, viewPagerHomeActivity
        ) { tab, position ->
            when (position) {
                0 -> tab.text = "Elektronik"
                1 -> tab.text = "Giyim"
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

        viewModel = ViewModelProviders.of(this).get(ProductViewModel::class.java)


    }


}