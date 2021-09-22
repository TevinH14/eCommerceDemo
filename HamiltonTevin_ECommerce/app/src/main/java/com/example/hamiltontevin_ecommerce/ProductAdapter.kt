package com.example.hamiltontevin_ecommerce

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_item.view.*

class ProductAdapter(var productList: List<ProductItem>?, private var clickListener: ((ProductItem) -> Unit)?):
    RecyclerView.Adapter<ProductAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        if(productList != null) {
            val product = productList!![pos]
            clickListener?.let { holder.bind(product, it) }
        }

    }

    override fun getItemCount(): Int {
        if(productList != null) {
            return productList!!.size
        }
        return 0
    }

    class ViewHolder(val view:View): RecyclerView.ViewHolder(view){

        fun bind(product: ProductItem,clickListener:(ProductItem)->Unit){
            view.tv_itemName.text = product.title
            view.tv_itemPrice.text = product.price.toString()
            Picasso.get().load(product.imageUrl).into(view.iv_itemImage)
            view.tv_itemRating.text = product.rate.toString()
            view.setOnClickListener {
                clickListener(product)
            }
        }


    }
}