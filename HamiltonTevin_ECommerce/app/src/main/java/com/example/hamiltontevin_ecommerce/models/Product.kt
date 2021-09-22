package com.example.hamiltontevin_ecommerce.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Product(@SerializedName("id")
                   @Expose
                   val id: Int,
                   @SerializedName("title")
                   @Expose
                   val title: String,
                   @SerializedName("price")
                   @Expose
                   val price: Double,
                   @SerializedName("description")
                   @Expose
                   val description: String,
                   @SerializedName("category")
                   @Expose
                   val category: String,
                   @SerializedName("image")
                   @Expose
                   val image: String,
                   @SerializedName("rating")
                   @Expose
                   val rating:Rating)
