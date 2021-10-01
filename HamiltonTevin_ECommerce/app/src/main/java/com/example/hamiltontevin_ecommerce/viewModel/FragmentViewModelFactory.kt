package com.example.hamiltontevin_ecommerce.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FragmentViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FragmentsViewModel::class.java)){
            return FragmentsViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}