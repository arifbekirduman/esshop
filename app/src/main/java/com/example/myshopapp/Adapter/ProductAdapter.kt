package com.example.myshopapp.Adapter

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshopapp.Models.ProductModel
import com.example.myshopapp.R
import kotlinx.android.synthetic.main.product_card_item.view.*

class ProductAdapter(var mOrderList: ArrayList<ProductModel>, var context: Context) : RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = (context as Activity).layoutInflater
        return MyViewHolder(inflater.inflate(R.layout.product_card_item, parent , false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 5
    }
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }




}