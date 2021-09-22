package com.example.hamiltontevin_ecommerce

import java.io.Serializable


data class ProductItem(val title: String, val price: Double, val description: String,
                       val category:String, val imageUrl:String,val rate: Float,
                       val count: Int):Serializable