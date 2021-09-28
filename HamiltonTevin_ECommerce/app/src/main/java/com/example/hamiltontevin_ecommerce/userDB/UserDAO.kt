package com.example.hamiltontevin_ecommerce.userDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDAO {

    @Insert
    suspend fun insertUser(user:User): Long

    @Update
    suspend fun updateUser(user:User):Int

    @Query("SELECT * FROM user_data_table WHERE id =:userID")
    fun getUser(userID: Int): User?

    @Query("SELECT * FROM user_data_table")
    fun getAllItems(): LiveData<List<User>>


}