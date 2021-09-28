package com.example.hamiltontevin_ecommerce.userDB

class UserRepository(private val dao : UserDAO) {
    val user = dao.getAllItems()

    //insert user
    suspend fun insert(user: User): Long{
        return dao.insertUser(user)
    }
    //update user data
    //
    suspend fun update(user: User): Int{
        return dao.updateUser(user)
    }

}