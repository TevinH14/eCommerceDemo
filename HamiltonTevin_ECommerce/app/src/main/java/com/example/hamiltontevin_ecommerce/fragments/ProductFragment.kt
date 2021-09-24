package com.example.hamiltontevin_ecommerce.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hamiltontevin_ecommerce.MainActivity
import com.example.hamiltontevin_ecommerce.ProductAdapter
import com.example.hamiltontevin_ecommerce.R
import com.example.hamiltontevin_ecommerce.models.ProductItem
import com.example.hamiltontevin_ecommerce.models.Products
import com.example.hamiltontevin_ecommerce.services.ProductService
import com.example.hamiltontevin_ecommerce.services.RetrofitInstance
import com.example.hamiltontevin_ecommerce.viewModel.FragmentsViewModel
import kotlinx.android.synthetic.main.product_fragment.view.*
import retrofit2.Response

class ProductFragment : Fragment() {
    private val model: FragmentsViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?):
            View? = inflater.inflate(R.layout.product_fragment,container,false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getProducts(view)
        //Create an instance of the recycleView a


    }

    private fun setView(view: View,products: Products){
        val recyclerView: RecyclerView = view.rv_productDisplayList
        val list: MutableLiveData<Products> = model.getList()
        val productAdapter = ProductAdapter(products) { selectedItem: ProductItem ->
            itemOnClicked(selectedItem)
        }
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = productAdapter
    }
    private fun getProducts(view: View){
        val list = Products()

        val retService:ProductService = RetrofitInstance
            .getRetrofitInstance()
            .create(ProductService::class.java)

        val responseLiveData:LiveData<Response<Products>> = liveData {
            val response:Response<Products> = retService.getItems()
            emit(response)
        }
        responseLiveData.observe(viewLifecycleOwner, Observer {
            val productsList:MutableListIterator<ProductItem>? = it.body()?.listIterator()
            if(productsList!=null){
                while(productsList.hasNext()){
                    list.add(productsList.next())
                    val productItem:ProductItem = productsList.next()
                    Log.i("mytag",productItem.title)
                }
                model.setList(list as Products)
                setView(view,list)
            }
        })

    }

    private fun itemOnClicked(item: ProductItem){
        model.setItem(item)
        (activity as MainActivity).replaceFragment(ProductDetailFragment())
    }

//    private fun createProduct():ArrayList<ProductItem> {
//        val list = arrayListOf<ProductItem>()
//        for (i in 1..8){
//            list.add(ProductItem("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
//                109.95,"new","tech",
//                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",3.9f,123))
//
//            list.add(ProductItem("Mens Casual Premium Slim Fit T-Shirts ",22.3,"new","tech",
//                "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg",1.5f,123))
//
//            list.add(ProductItem("Mens Cotton Jacket",55.99,"new","tech",
//                "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg",1.5f,123))
//
//            list.add(ProductItem("Mens Casual Slim Fit",15.99,"new","tech",
//                "https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg",1.5f,123))
//
//        }
//        return list
//    }

}