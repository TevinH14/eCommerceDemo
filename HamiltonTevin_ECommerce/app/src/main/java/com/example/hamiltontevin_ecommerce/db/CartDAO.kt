package com.example.hamiltontevin_ecommerce.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CartDAO {

    @Insert
    suspend fun insertItem(cart: Cart): Long

    @Update
    suspend fun updateItems(cart: Cart):Int

    @Delete
    suspend fun delete(cart: Cart):Int


    @Query("DELETE FROM cart_data_table")
    suspend fun deleteAll():Int

    @Query("SELECT * FROM cart_data_table")
     fun getAllItems(): LiveData<List<Cart>>

    @Query("SELECT EXISTS (SELECT 1 FROM cart_data_table WHERE id = :id)")
    suspend fun exists(id: Int): Boolean

    @Query("UPDATE cart_data_table SET item_quantity = item_quantity + 1 WHERE id = :id")
    suspend fun updateQuantity(id: Int)


    @Query("SELECT  SUM(item_price * item_quantity) FROM CART_DATA_TABLE")
     fun total():LiveData<Double>


}