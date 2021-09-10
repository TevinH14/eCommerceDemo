package com.example.hamiltontevin_ecommerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.hamiltontevin_ecommerce.fragments.AccountFragment
import com.example.hamiltontevin_ecommerce.fragments.CartFragment
import com.example.hamiltontevin_ecommerce.fragments.ProductFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        title = "Home"
        if(savedInstanceState == null){

           setFragment(ProductFragment())
            navigationView.menu.getItem(1).isChecked = true
        }

        navigationView.setOnNavigationItemSelectedListener() { menu ->
            when(menu.itemId){
                R.id.nav_person ->{
                    Log.i("fap","nav person")
                    setFragment(AccountFragment())
                    title = "Account"
                    true
                }
                R.id.nav_home ->{
                    Log.i("fap","nav home")
                    setFragment(ProductFragment())
                    title = "Home"
                    true
                }
                R.id.nav_cart ->{
                    Log.i("fap","nav car")
                    setFragment(CartFragment())
                    title = "Cart"
                    true
                }
                else -> false

            }

        }
    }

    private fun setFragment(_fragment: Fragment){
        val fragmentManger = supportFragmentManager.beginTransaction()
        fragmentManger.replace(R.id.fragment_product_view,_fragment)
        fragmentManger.commit()
    }
}