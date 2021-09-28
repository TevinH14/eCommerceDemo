package com.example.hamiltontevin_ecommerce.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hamiltontevin_ecommerce.CartAdapter
import com.example.hamiltontevin_ecommerce.MainActivity
import com.example.hamiltontevin_ecommerce.R
import com.example.hamiltontevin_ecommerce.db.Cart
import com.example.hamiltontevin_ecommerce.viewModel.FragmentsViewModel
import kotlinx.android.synthetic.main.cart_fragment.view.*

class CartFragment : Fragment() {
    private val model: FragmentsViewModel by activityViewModels()
    private lateinit var adapter:CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.cart_fragment,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter(view)
    }

    private fun setAdapter(view: View){
        //add a item touch helper
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            0, ItemTouchHelper.LEFT) {
                //return false not needed due to not moving rows up and down
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    adapter.removeAt(viewHolder.adapterPosition)
                }
            }

        val recyclerView: RecyclerView = view.rv_cartList
        adapter =  CartAdapter(model) {item: Cart -> itemOnClicked(item) }
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
        displayCartItems()
    }

    private fun displayCartItems(){
        model.cartItems.observe(viewLifecycleOwner, Observer {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })
    }

    private fun itemOnClicked(item: Cart){
        model.setItem(model.cartToProduct(item))
       (activity as MainActivity).replaceFragment(ProductDetailFragment())
    }
}