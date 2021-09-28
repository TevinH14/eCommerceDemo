package com.example.hamiltontevin_ecommerce.viewModel

import android.util.Log
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hamiltontevin_ecommerce.db.Cart
import com.example.hamiltontevin_ecommerce.db.CartRepository
import com.example.hamiltontevin_ecommerce.models.ProductItem
import com.example.hamiltontevin_ecommerce.models.Rating
import com.example.hamiltontevin_ecommerce.userDB.UserRepository
import kotlinx.coroutines.launch

class FragmentsViewModel(private val cartRepository: CartRepository, private val userRepository:UserRepository): ViewModel(), Observable {

    //shared Data
    private val productLiveData: MutableLiveData<ProductItem> = MutableLiveData()

    //set selected product
    fun setItem(input: ProductItem) {
        productLiveData.value = input
    }

    //get selected product
    fun getItem(): MutableLiveData<ProductItem> = productLiveData
    //get all cart rows from database


    val cartItems = cartRepository.cart
    val user = userRepository.user



    //turn cart item to productItem
    fun cartToProduct(cart: Cart):ProductItem{
        return ProductItem(
            cart.itemId,
            cart.title,
            cart.price,
            cart.description,
            cart.category,
            cart.image,
            Rating(0,cart.rating))
    }

    fun addToCart(){
        //val cart: Cart = Cart()
        //insert(cart)
    }

    //insert product to cart database
    fun insert(products: ProductItem) = viewModelScope.launch {

         val cart = Cart(products.id,
             products.title,
             products.price,
             products.description,
             products.category,
             products.image,
         products.rating.rate)

        val newRowId = cartRepository.insert(cart)
        if (newRowId > -1) {
           Log.i("fab" ,"cart Inserted Successfully $newRowId")
        }

    }

    //delete product from cart database
    fun delete(cartItem: Cart) = viewModelScope.launch {
        cartRepository.delete(cartItem)

    }

    //currently not needed
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

}