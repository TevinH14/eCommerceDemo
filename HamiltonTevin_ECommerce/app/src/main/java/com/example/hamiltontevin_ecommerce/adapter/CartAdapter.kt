package com.example.hamiltontevin_ecommerce

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hamiltontevin_ecommerce.db.Cart
import com.example.hamiltontevin_ecommerce.viewModel.FragmentsViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_item.view.*

class CartAdapter(private val model: FragmentsViewModel,private val clickListener:((Cart)->Unit)?)
    : RecyclerView.Adapter<CartViewHolder> (){
    private val cartList = ArrayList<Cart>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {

       val itemView = LayoutInflater.from(parent.context)
           .inflate(R.layout.product_item,parent,false)
        return CartViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cart = cartList[position]
        clickListener?.let{holder.bind(cart,it)}
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    //clear and reset list
    fun setList(list: List<Cart>){
        cartList.clear()
        cartList.addAll(list)
    }

    //remove item at swiped row
    fun removeAt(pos: Int) {
        model.delete(cartList[pos])
        cartList.removeAt(pos)
        notifyItemRemoved(pos)
    }
}

class CartViewHolder(private val view: View): RecyclerView.ViewHolder(view){
    //display data in a row
    fun bind(cartItem:Cart,clickListener: (Cart) -> Unit){
        view.tv_itemName.text = cartItem.title
        view.tv_itemPrice.text = cartItem.price.toString()
        view.tv_itemRating.text = cartItem.rating.toString()
        Picasso.get().load(cartItem.image).into(view.iv_itemImage)
        view.setOnClickListener {
            clickListener(cartItem)
        }
    }

}