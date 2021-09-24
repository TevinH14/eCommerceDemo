package com.example.hamiltontevin_ecommerce.services

import com.example.hamiltontevin_ecommerce.models.Products
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {
    @GET("products")
    suspend fun getItems(): Response <Products>
}