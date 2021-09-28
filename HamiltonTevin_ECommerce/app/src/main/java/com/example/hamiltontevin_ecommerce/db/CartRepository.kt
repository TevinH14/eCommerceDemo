package com.example.hamiltontevin_ecommerce.db

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

    // delete all cart items
    suspend fun deleteAll():Int {
        return dao.deleteAll()
    }
}