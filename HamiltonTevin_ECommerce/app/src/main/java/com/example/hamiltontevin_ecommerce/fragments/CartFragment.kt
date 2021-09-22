package com.example.hamiltontevin_ecommerce.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hamiltontevin_ecommerce.ProductAdapter
import com.example.hamiltontevin_ecommerce.ProductItem
import com.example.hamiltontevin_ecommerce.R

public class CartFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.cart_fragment,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.rv_cartList)
        val productList = createProduct()
        val productAdapter = ProductAdapter(productList,null)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val tv_total: TextView = view.findViewById(R.id.tv_cartTotal)

        var totalNum: Double = 0.0
        for (item in productList ){
            totalNum +=item.price
        }

        tv_total.text = "\$" + totalNum.toString()

        //setting adapter to recyclerView
        recyclerView.adapter = productAdapter
    }


    private fun createProduct():ArrayList<ProductItem> {
        val list = arrayListOf<ProductItem>()
        list.add(ProductItem("Mens Cotton Jacket",55.99,"new","tech",
            "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg",1.5f,123))

        list.add(ProductItem("Mens Casual Slim Fit",15.99,"new","tech",
            "https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg",1.5f,123))
        return list
    }
}