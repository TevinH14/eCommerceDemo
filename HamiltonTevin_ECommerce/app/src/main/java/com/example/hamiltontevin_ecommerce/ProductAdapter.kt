package com.example.hamiltontevin_ecommerce

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductAdapter(var productList: List<ProductItem>):
    RecyclerView.Adapter<ProductAdapter.ViewHolder>(){

    inner class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        var itemImage: ImageView = view.findViewById(R.id.iv_itemImage)
        var title: TextView = view.findViewById(R.id.tv_itemName)
        var price: TextView = view.findViewById(R.id.tv_itemPrice)
        var rating: TextView = view.findViewById(R.id.tv_itemRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        val product = productList[pos]

        holder.title.text = product.title
        holder.price.text = product.price.toString()
        holder.rating.text = product.rate.toString()
        Picasso.get().load(product.imageUrl).into(holder.itemImage)
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}