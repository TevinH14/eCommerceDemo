package com.example.hamiltontevin_ecommerce.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hamiltontevin_ecommerce.MainActivity
import com.example.hamiltontevin_ecommerce.R
import com.example.hamiltontevin_ecommerce.models.ProductItem
import com.example.hamiltontevin_ecommerce.viewModel.FragmentsViewModel
import kotlinx.android.synthetic.main.cart_fragment.view.*

class CartFragment : Fragment() {
    private val model: FragmentsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.cart_fragment,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createAdapter(view)
    }

    private fun createAdapter(view: View){
        val recyclerView: RecyclerView = view.rv_cartList
       // val productList = createProduct()
//        val productAdapter = ProductAdapter(createProduct()) { selectedItem: ProductItem ->
//            itemOnClicked(selectedItem)
//        }
        recyclerView.layoutManager = LinearLayoutManager(context)

        val tvTotal: TextView = view.findViewById(R.id.tv_cartTotal)

        var totalNum: Double = 0.0
//        for (item in productList ){
//            totalNum +=item.price
//        }

        tvTotal.text = "\$" + totalNum.toString()

        //setting adapter to recyclerView
      //  recyclerView.adapter = productAdapter
    }

    private fun itemOnClicked(item: ProductItem){
        model.setItem(item)
        (activity as MainActivity).replaceFragment(ProductDetailFragment())
    }
}