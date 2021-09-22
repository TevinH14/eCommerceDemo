package com.example.hamiltontevin_ecommerce.services

import com.example.hamiltontevin_ecommerce.models.ProductList
import retrofit2.Response
import retrofit2.http.GET

interface GetProductService {
    @GET("product")
    suspend fun getProduct(): Response <ProductList>
}