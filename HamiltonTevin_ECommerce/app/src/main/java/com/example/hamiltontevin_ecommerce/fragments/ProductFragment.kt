package com.example.hamiltontevin_ecommerce.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hamiltontevin_ecommerce.ProductAdapter
import com.example.hamiltontevin_ecommerce.ProductItem
import com.example.hamiltontevin_ecommerce.R

class ProductFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?):
            View? = inflater.inflate(R.layout.product_fragment,container,false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.rv_productDisplayList)

        val productAdapter = ProductAdapter(createProduct())
        recyclerView.layoutManager = LinearLayoutManager(context)

        //setting adapter to recyclerView
        recyclerView.adapter = productAdapter

    }

    private fun createProduct():ArrayList<ProductItem> {
        val list = arrayListOf<ProductItem>()
        for (i in 1..8){
            list.add(ProductItem("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                109.95,"new","tech",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",3.9f,123))

            list.add(ProductItem("Mens Casual Premium Slim Fit T-Shirts ",22.3,"new","tech",
                "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg",1.5f,123))

            list.add(ProductItem("Mens Cotton Jacket",55.99,"new","tech",
                "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg",1.5f,123))

            list.add(ProductItem("Mens Casual Slim Fit",15.99,"new","tech",
                "https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg",1.5f,123))

        }
        return list
    }

}