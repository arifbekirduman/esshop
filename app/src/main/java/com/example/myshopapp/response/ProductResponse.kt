package com.example.myshopapp.response

import com.example.myshopapp.models.ProductModel

data class ProductResponse(
    val data: List<ProductModel>,
    val message: Any,
    val success: Boolean
) {

}