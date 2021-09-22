package com.example.hamiltontevin_ecommerce.viewModel

import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hamiltontevin_ecommerce.ProductItem
import com.example.hamiltontevin_ecommerce.db.Cart
import com.example.hamiltontevin_ecommerce.db.CartRepository
import kotlinx.coroutines.launch

class FragmentsViewModel(private val repository: CartRepository): ViewModel(), Observable {
    val cart = repository.cart
    val total = 0.0

    private val mutableLiveData: MutableLiveData<ProductItem> = MutableLiveData()

    fun setProduct(input: ProductItem) {
        mutableLiveData.value = input
    }
    fun getProduct(): MutableLiveData<ProductItem> = mutableLiveData

    fun insert(cart: Cart) = viewModelScope.launch {
        val newRowId = repository.insert(cart)

    }
    fun delete(subscriber: Cart) = viewModelScope.launch {
        val noOfRowsDeleted = repository.delete(subscriber)

    }
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

}