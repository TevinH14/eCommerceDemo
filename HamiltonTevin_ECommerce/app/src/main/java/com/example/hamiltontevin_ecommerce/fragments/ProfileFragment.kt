package com.example.hamiltontevin_ecommerce.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.hamiltontevin_ecommerce.R
import com.example.hamiltontevin_ecommerce.databinding.ProfileDisplayFragmentBinding
import com.example.hamiltontevin_ecommerce.userDB.User
import com.example.hamiltontevin_ecommerce.viewModel.FragmentsViewModel

class ProfileFragment :Fragment(){

    //view model reference
    private val model: FragmentsViewModel by activityViewModels()
    private lateinit var user:User
    private lateinit var binding:ProfileDisplayFragmentBinding




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?{

        binding = DataBindingUtil.inflate(inflater,R.layout.profile_display_fragment,container,false)
        binding.viewModel = model
        binding.lifecycleOwner = this
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getUser()
    }

     fun getUser(){
        model.userInfo.observe(viewLifecycleOwner, Observer <List<User>> {
            if(it != null){
                Log.i("user", it.size.toString())
                if (it.isNotEmpty()){
                    user = it[0]
                    model. fullNameLiveData.value= user.fullName
                    model. emailLiveData.value = user.emailAddress
                    model. phoneNumLiveData.value = user.phoneNumber
                    model.isUser.value = true
                }
            }
            else{
                Log.i("user", "empty")
            }
        })
    }
}