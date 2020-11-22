package com.example.myshopapp.Utils

import android.content.Context
import android.content.Intent
import com.example.myshopapp.View.CardActivity
import com.example.myshopapp.View.HomeActivity
import com.example.myshopapp.View.ProfileActivity
import com.example.myshopapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationViewHelper {
    companion object{
        fun setupBottomNavigationView(
            context: Context,
            bottomNavigationView: BottomNavigationView
        ) {
            bottomNavigationView.setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigationHome -> {
                        context.startActivity(
                            Intent(
                                context,
                                HomeActivity::class.java
                            ).setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)

                        )
                        true
                    }
                    R.id.navigationComment -> {
                        context.startActivity(
                            Intent(
                                context,
                                CardActivity::class.java
                            ).setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)

                        )
                        true
                    }
                    R.id.navigationProfile -> {
                        context.startActivity(
                            Intent(
                                context,
                                ProfileActivity::class.java
                            ).setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)

                        )
                        true
                    }
                    else -> false
                }
            }
        }
    }

}