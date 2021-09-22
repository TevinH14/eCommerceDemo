package com.example.hamiltontevin_ecommerce.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.hamiltontevin_ecommerce.ProductItem
import com.example.hamiltontevin_ecommerce.viewModel.FragmentsViewModel

public class ProductDetailFragment: Fragment() {
    private  var productItem:ProductItem? = null
    private val model: FragmentsViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productItem = model.getProduct().value
        if(productItem != null){

        }

    }
}