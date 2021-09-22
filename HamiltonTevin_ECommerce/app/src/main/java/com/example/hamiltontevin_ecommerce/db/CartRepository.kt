package com.example.hamiltontevin_ecommerce.db

class CartRepository(private val dao : CartDAO) {

    val cart = dao.getAllItems()

    suspend fun insert(cart: Cart): Long {
        return dao.insertItem(cart)
    }

    suspend fun update(cart: Cart):Int{
        return dao.updateItems(cart)
    }

    suspend fun delete(cart: Cart):Int {
        return dao.delete(cart)
    }

    suspend fun deleteAll():Int {
        return dao.deleteAll()
    }
}