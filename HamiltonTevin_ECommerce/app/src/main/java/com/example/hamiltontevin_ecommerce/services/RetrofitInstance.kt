package com.example.hamiltontevin_ecommerce.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {
    companion object {
        private const val BASE_URL = "https://fakestoreapi.com/"

        private val httpLogging = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        private val client = OkHttpClient.Builder().apply {
            this.addInterceptor(httpLogging)
                .connectTimeout(30,TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
        }.build()

        // Create Retrofit
        private val retrofit = Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRetrofitInstance(): Retrofit{
        return retrofit
    }
}