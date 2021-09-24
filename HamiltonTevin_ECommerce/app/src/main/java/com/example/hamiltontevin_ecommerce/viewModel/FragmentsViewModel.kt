package com.example.hamiltontevin_ecommerce.viewModel

import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hamiltontevin_ecommerce.db.Cart
import com.example.hamiltontevin_ecommerce.db.CartRepository
import com.example.hamiltontevin_ecommerce.models.ProductItem
import com.example.hamiltontevin_ecommerce.models.Products
import kotlinx.coroutines.launch

class FragmentsViewModel(private val repository: CartRepository): ViewModel(), Observable {

    val cartRepository = repository.cart
    val total = 0.0

    private val productLiveData: MutableLiveData<ProductItem> = MutableLiveData()
    private val productListLiveData:MutableLiveData<Products> = MutableLiveData()

    //set and get product is used to transfer data between fragments
    fun setItem(input: ProductItem) {
        productLiveData.value = input
    }
    fun getItem(): MutableLiveData<ProductItem> = productLiveData

    //set and get product is used to transfer data between fragments
    fun setList(input: Products) {
        productListLiveData.value = input
    }
    fun getList(): MutableLiveData<Products> = productListLiveData

    fun addToCart(){
        //val cart: Cart = Cart()
        //insert(cart)
    }

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