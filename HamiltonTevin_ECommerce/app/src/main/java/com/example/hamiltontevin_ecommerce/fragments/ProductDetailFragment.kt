package com.example.hamiltontevin_ecommerce.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.hamiltontevin_ecommerce.R
import com.example.hamiltontevin_ecommerce.models.ProductItem
import com.example.hamiltontevin_ecommerce.viewModel.FragmentsViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_detail_fragment.view.*

class ProductDetailFragment: Fragment(), View.OnClickListener {
    private  var productItem: ProductItem? = null
    private val model: FragmentsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? = inflater
        .inflate(R.layout.product_detail_fragment,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView(view)

        val btnAddToCart:Button = view.findViewById(R.id.btn_addToCart)
        btnAddToCart.setOnClickListener(this)

    }

    private fun setView(view: View){
        productItem = model.getItem().value
        if(productItem != null){
            view.tv_title_pd.text = productItem!!.title
            view.tv_Rating_pd.text = productItem!!.rating.rate.toString()
            view.tv_price_pd.text = productItem!!.price.toString()
            view.tv_description_pd.text = productItem!!.description
            view.tv_category_pd.text = productItem!!.category

            Picasso.get().load(productItem!!.image).into(view.iv_itemImage_pd)

        }
    }

    override fun onClick(view: View?) {
        if(view?.id == R.id.btn_addToCart){
            Toast.makeText(context,"Item added to cart", Toast.LENGTH_SHORT).show()
            model.insertItem(productItem!!)
        }
    }
}