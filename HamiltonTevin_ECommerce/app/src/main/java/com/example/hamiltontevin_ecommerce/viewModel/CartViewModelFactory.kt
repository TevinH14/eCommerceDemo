package com.example.hamiltontevin_ecommerce.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hamiltontevin_ecommerce.db.CartRepository

class CartViewModelFactory(private val repository: CartRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FragmentsViewModel::class.java)){
            return FragmentsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}