package com.example.hamiltontevin_ecommerce.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hamiltontevin_ecommerce.MainActivity
import com.example.hamiltontevin_ecommerce.R
import com.example.hamiltontevin_ecommerce.adapter.ProductAdapter
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
                var count = 0
                while(productsList.hasNext()){
                    count++
                    Log.i("count", "current count$count")
                    list.add(productsList.next())
                    Log.i("current count",list.count().toString())

                }
                setView(view,list)
            }
        })

    }

    private fun itemOnClicked(item: ProductItem){
        model.setItem(item)
       (activity as MainActivity).replaceFragment(ProductDetailFragment())
    }

}