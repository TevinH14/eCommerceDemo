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

    @Query("SELECT * FROM cart_data_table")
    fun getAll(): List<Cart>

    @Query("DELETE FROM cart_data_table")
    suspend fun deleteAll():Int

    @Query("SELECT * FROM cart_data_table")
    fun getAllItems(): LiveData<List<Cart>>
}