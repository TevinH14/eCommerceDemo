package com.example.hamiltontevin_ecommerce.userDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User_data_table")
class User (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val Id : Int,

    @ColumnInfo(name = "full_name")
    val fullName : String,

    @ColumnInfo(name = "email_Address")
    val emailAddress : String,

    @ColumnInfo(name = "phone_number")
    val phoneNumber : String
    )
