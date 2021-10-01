package com.example.hamiltontevin_ecommerce.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.hamiltontevin_ecommerce.db.Cart
import com.example.hamiltontevin_ecommerce.db.CartDatabase
import com.example.hamiltontevin_ecommerce.db.CartRepository
import com.example.hamiltontevin_ecommerce.models.ProductItem
import com.example.hamiltontevin_ecommerce.models.Rating
import com.example.hamiltontevin_ecommerce.userDB.User
import com.example.hamiltontevin_ecommerce.userDB.UserDatabase
import com.example.hamiltontevin_ecommerce.userDB.UserRepository
import kotlinx.coroutines.launch

class FragmentsViewModel(application: Application): AndroidViewModel(application) {
    //Repository instance
    var cartRepository:CartRepository
    var userRepository:UserRepository

    //shared Data with product detail view
    private val productLiveData: MutableLiveData<ProductItem> = MutableLiveData()

    //live data objects for profile fragment
    val fullNameLiveData: MutableLiveData<String> = MutableLiveData()
    val emailLiveData: MutableLiveData<String> = MutableLiveData()
    val phoneNumLiveData: MutableLiveData<String> = MutableLiveData()
    val btnTextLiveData: MutableLiveData<String> = MutableLiveData()
    val editMode: MutableLiveData<Boolean> = MutableLiveData()
    val isUser: MutableLiveData<Boolean> = MutableLiveData()


    init {
        editMode.value = false
        isUser.value = false

        val dao = CartDatabase.getInstance(application).cartDAO
         cartRepository = CartRepository(dao)
        val userDAO = UserDatabase.getInstance(application).userDAO
         userRepository = UserRepository(userDAO)
    }

    val cartItems = cartRepository.cart
    val userInfo = userRepository.user

    val total = cartRepository.total()


    fun onButtonClick(){
        editMode.value = !editMode.value!!

        if(isUser.value!!){
            updateUser(User(1
                ,fullNameLiveData.value!!
                ,emailLiveData.value!!
                ,phoneNumLiveData.value!!

            ))
        }
        else{
            if(!editMode.value!!){
                insertUser(User(1
                    ,fullNameLiveData.value!!
                    ,emailLiveData.value!!
                    ,phoneNumLiveData.value!!
                ))
            }
        }

    }

    //set selected product
    fun setItem(input: ProductItem) {
        productLiveData.value = input
    }

    //get selected product
    fun getItem(): MutableLiveData<ProductItem> = productLiveData


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

    //insert product to cart database
    fun insertItem(products: ProductItem) = viewModelScope.launch {
        val exists = cartRepository.exists(products.id)
        if(!exists){
            val cart = Cart(products.id,
                products.title,
                products.price,
                products.description,
                products.category,
                products.image,
                products.rating.rate,
                1
            )
             cartRepository.insert(cart)
        }else{
          cartRepository.updateQuantity(products.id)
        }
    }
    //delete product from cart database
    fun deleteItem(cartItem: Cart) = viewModelScope.launch {
        cartRepository.delete(cartItem)

    }

    fun insertUser(user: User) = viewModelScope.launch {
        userRepository.insert(user)
    }

    fun updateUser(user: User) = viewModelScope.launch {
        userRepository.update(user)
    }
}