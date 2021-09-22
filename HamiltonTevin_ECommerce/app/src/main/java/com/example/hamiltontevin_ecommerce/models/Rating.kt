package com.example.hamiltontevin_ecommerce.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Rating(@SerializedName("rate")
                  @Expose
                  val rate:Double,
                  @SerializedName("count")
                  @Expose
                  val count:Int)