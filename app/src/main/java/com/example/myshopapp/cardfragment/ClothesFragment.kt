package com.example.myshopapp.cardfragment

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshopapp.R
import com.example.myshopapp.adapter.ProductAdapter
import com.example.myshopapp.models.ProductModel
import com.example.myshopapp.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.fragment_mens_fashion.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MensFashionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MensFashionFragment() : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var productList = ArrayList<ProductModel>()
    var categoryList = ArrayList<String>()
    var context: Activity? = null
    private lateinit var viewModelProduct: ProductViewModel
    var isCategoryClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        context = activity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mens_fashion, container, false)

        viewModelProduct = ViewModelProviders.of(this).get(ProductViewModel::class.java)
        getCategory(view)

        requireActivity().onBackPressedDispatcher.addCallback(object :
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (isCategoryClicked) {
                    view.recyclerViewMensFashion.visibility = View.GONE
                    view.listView.visibility = View.VISIBLE
                    productList.clear()
                    getCategoryAdapter(view)
                    isCategoryClicked = false
                } else {
                    Log.e("burda", isCategoryClicked.toString())
                    isEnabled = false
                    activity!!.onBackPressed()
                }
            }

        })



        return view
    }

    private fun getCategory(view: View) {
        viewModelProduct.getCategory().observe(this, Observer {
            if (it != null) {
                for (item in it.data) {
                    categoryList.add(item.categoryName!!)
                    getCategoryAdapter(view)
                }
            }
        })
    }

    private fun getCategoryAdapter(viewP: View) {
        if (context != null) {
            val tempAdapter =
                ArrayAdapter(context!!, android.R.layout.simple_list_item_1, categoryList)
            viewP.recyclerViewMensFashion.visibility = View.GONE
            viewP.listView.visibility = View.VISIBLE
            viewP.listView.adapter = tempAdapter

            viewP.listView.onItemClickListener =
                AdapterView.OnItemClickListener { parent, view, position, id ->
                    isCategoryClicked = true
                    getProduct(position + 1, viewP)
                }
        } else {
            Log.e("listview", "null")
        }
    }

    private fun getProduct(position: Int, view: View) {
        viewModelProduct.getProductById(position).observe(this, Observer {
            if (it != null) {
                productList.addAll(it.data)

                getProductAdapter(view)

            }
        })
    }

    private fun getProductAdapter(view: View) {
        if (context != null) {
            val adapter = ProductAdapter(productList, context!!)
            view.listView.visibility = View.GONE
            view.recyclerViewMensFashion.visibility = View.VISIBLE

            view.recyclerViewMensFashion.adapter = adapter
            val linearLayoutManager = LinearLayoutManager(context)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            view.recyclerViewMensFashion.layoutManager = linearLayoutManager
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BoysFashionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MensFashionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}