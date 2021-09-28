package com.example.hamiltontevin_ecommerce.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hamiltontevin_ecommerce.db.CartRepository
import com.example.hamiltontevin_ecommerce.userDB.UserRepository

class FragmentViewModelFactory(private val repository: CartRepository,
                               private val userRepository: UserRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FragmentsViewModel::class.java)){
            return FragmentsViewModel(repository,userRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}