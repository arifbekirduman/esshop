package com.example.myshopapp.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myshopapp.cardfragment.MensFashionFragment
import com.example.myshopapp.cardfragment.WomensFashionFragment

class HomePagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    var context :Context = fragmentActivity

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {

            when(position){
                0 -> return MensFashionFragment()
                1 -> return WomensFashionFragment()
                else -> return MensFashionFragment()
            }
    }
}