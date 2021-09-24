package com.example.hamiltontevin_ecommerce

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.hamiltontevin_ecommerce.databinding.ActivityMainBinding
import com.example.hamiltontevin_ecommerce.db.CartDatabase
import com.example.hamiltontevin_ecommerce.db.CartRepository
import com.example.hamiltontevin_ecommerce.fragments.AccountFragment
import com.example.hamiltontevin_ecommerce.fragments.CartFragment
import com.example.hamiltontevin_ecommerce.fragments.ProductDetailFragment
import com.example.hamiltontevin_ecommerce.fragments.ProductFragment
import com.example.hamiltontevin_ecommerce.viewModel.CartViewModelFactory
import com.example.hamiltontevin_ecommerce.viewModel.FragmentsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentViewModel: FragmentsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpDatabase()

        title = "Home"
        if (savedInstanceState == null) {
//            binding.bottomNavigation.menu.getItem(1).isChecked = true

            replaceFragment(ProductFragment())
        }
        setUpNav()
        binding.bottomNavigation.setOnItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.nav_person -> {
                    Log.i("fap", "nav person")
                    replaceFragment(AccountFragment())
                    title = "Account"
                    true
                }
                R.id.nav_home -> {
                    Log.i("fap", "nav home")
                    replaceFragment(ProductFragment())
                    title = "Home"
                    true
                }
                R.id.nav_cart -> {
                    Log.i("fap", "nav car")
                    replaceFragment(CartFragment())
                    title = "Cart"
                    true
                }
                else -> false
            }
        }
    }

    private fun setUpNav(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConf = AppBarConfiguration(setOf(
            R.id.nav_home, R.id.nav_cart,R.id.nav_person,R.id.productDetail
        ))
        setupActionBarWithNavController(navController, appBarConf)
        binding.bottomNavigation.setupWithNavController(navController)
    }

    private fun setUpDatabase(){
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val dao = CartDatabase.getInstance(application).cartDAO
        val repository = CartRepository(dao)
        val factory = CartViewModelFactory(repository)
        fragmentViewModel = ViewModelProvider(this,factory).get(FragmentsViewModel::class.java)
        binding.myViewModel = fragmentViewModel
        binding.lifecycleOwner = this

        binding.bottomNavigation.menu.getItem(1).isChecked = true
    }

    fun replaceFragment(_fragment: Fragment) {
        val fragmentManger = supportFragmentManager.beginTransaction()
        if(_fragment == ProductDetailFragment()){
            fragmentManger.addToBackStack("product_Fragment")
        }
        fragmentManger.replace(R.id.nav_host_fragment, _fragment)
        fragmentManger.commit()
    }

}
