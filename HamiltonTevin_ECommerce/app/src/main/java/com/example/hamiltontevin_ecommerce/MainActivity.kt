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
import com.example.hamiltontevin_ecommerce.fragments.CartFragment
import com.example.hamiltontevin_ecommerce.fragments.ProductDetailFragment
import com.example.hamiltontevin_ecommerce.fragments.ProductFragment
import com.example.hamiltontevin_ecommerce.fragments.ProfileFragment
import com.example.hamiltontevin_ecommerce.userDB.UserDatabase
import com.example.hamiltontevin_ecommerce.userDB.UserRepository
import com.example.hamiltontevin_ecommerce.viewModel.FragmentsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentViewModel: FragmentsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        setUpDatabase()
        setToolBarText("Product")
        if (savedInstanceState == null) {
            replaceFragment(ProductFragment())
        }
        setUpNav()
        binding.bottomNavigation.setOnItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.nav_person -> {
                    Log.i("fap", "nav person")
                    replaceFragment(ProfileFragment())
                    setToolBarText("Profile")
                    true
                }
                R.id.nav_home -> {
                    Log.i("fap", "nav home")
                     replaceFragment(ProductFragment())
                    setToolBarText("Product")
                    true
                }
                R.id.nav_cart -> {
                    Log.i("fap", "nav car")
                     replaceFragment(CartFragment())
                    setToolBarText("Cart")
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
        val cartRepository = CartRepository(dao)
        val userDAO = UserDatabase.getInstance(application).userDAO
        val userRepository = UserRepository(userDAO)
       // val factory = FragmentViewModelFactory(cartRepository,userRepository)
        fragmentViewModel = ViewModelProvider(this).get(FragmentsViewModel::class.java)
        binding.myViewModel = fragmentViewModel
        binding.lifecycleOwner = this
    }

    private fun setToolBarText(_title:String){
        toolbar_title.text =_title
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
