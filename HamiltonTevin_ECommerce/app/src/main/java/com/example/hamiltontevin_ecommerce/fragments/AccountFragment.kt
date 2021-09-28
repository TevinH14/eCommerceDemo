package com.example.hamiltontevin_ecommerce.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.hamiltontevin_ecommerce.R
import com.example.hamiltontevin_ecommerce.viewModel.FragmentsViewModel
import kotlinx.android.synthetic.main.account_fragment.*

public class AccountFragment :Fragment(),View.OnClickListener {

    //view model reference
    private val model: FragmentsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.account_fragment,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn_edit:Button = view.findViewById(R.id.btn_editUser)
        btn_edit.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        if (view != null) {
            if(view.id == R.id.btn_editUser){
                if(btn_editUser.text == "Edit"){
                    val name = tv_userName.text.toString()
                    val email = tv_userEAddress.text
                    val num = tv_userPNumber.text

                    tv_userName.visibility = View.GONE
                    tv_userPNumber.visibility = View.GONE
                    tv_userEAddress.visibility = View.GONE

                    et_fullName.visibility = View.VISIBLE
                    et_eAddress.visibility = View.VISIBLE
                    et_pNumber.visibility = View.VISIBLE

                    btn_editUser.text = getString(R.string.save)


                }else{
                    et_fullName.visibility = View.GONE
                    et_eAddress.visibility = View.GONE
                    et_pNumber.visibility = View.GONE

                    tv_userName.visibility =View.VISIBLE
                    tv_userPNumber.visibility = View.VISIBLE
                    tv_userEAddress.visibility = View.VISIBLE

                    btn_editUser.text = getString(R.string.edit)
                }
            }
        }
    }

}