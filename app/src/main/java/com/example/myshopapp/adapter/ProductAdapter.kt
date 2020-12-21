package com.example.myshopapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myshopapp.R
import com.example.myshopapp.databinding.CategoryCardItemBinding
import com.example.myshopapp.models.ProductModel

class ProductAdapter(var mOrderList: ArrayList<ProductModel>, var context: Context) :
    RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {
    private var layoutInflater: LayoutInflater? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(context)
        }
        val dataBinding : CategoryCardItemBinding = DataBindingUtil.inflate(layoutInflater!!,R.layout.category_card_item,parent,false)

        return MyViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindProduct(mOrderList.get(position))
    }

    override fun getItemCount(): Int {
        return mOrderList.size
    }

    class MyViewHolder(private val productCardItemBinding: CategoryCardItemBinding) :
        RecyclerView.ViewHolder(productCardItemBinding.root) {
        fun bindProduct(product: ProductModel) {
            productCardItemBinding.item = product
            productCardItemBinding.executePendingBindings()
        }
    }
}