package com.example.hamiltontevin_ecommerce.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cart_data_table")
data class Cart(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "item_id")
    val itemId : Int,

    @ColumnInfo(name = "item_title")
    val title : String,

    @ColumnInfo(name = "item_price")
    val price : Double,

    @ColumnInfo(name = "item_description")
    val description : String,

    @ColumnInfo(name = "item_category")
    val category: String,

    @ColumnInfo(name = "item_image")
    val image : String,

    @ColumnInfo(name = "item_rating")
    val rating : Double

    )
