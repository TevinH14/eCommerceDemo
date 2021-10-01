package com.example.hamiltontevin_ecommerce.db

import androidx.lifecycle.LiveData

class CartRepository(private val dao : CartDAO) {

    val cart = dao.getAllItems()

    //insert to database
    suspend fun insert(cart: Cart): Long {
        return dao.insertItem(cart)
    }

    // delete the cart coming in as an arguement
    suspend fun delete(cart: Cart):Int {
        return dao.delete(cart)
    }

     suspend fun exists(int: Int):Boolean{
        return dao.exists(int)
    }

    suspend fun updateQuantity(int: Int){
        return dao.updateQuantity(int)
    }
     fun total():LiveData<Double>{
        return dao.total()
    }

    // delete all cart items
    suspend fun deleteAll():Int {
        return dao.deleteAll()
    }

}