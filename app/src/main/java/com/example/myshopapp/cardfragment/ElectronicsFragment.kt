package com.example.myshopapp.cardfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myshopapp.adapter.ProductAdapter
import com.example.myshopapp.response.ProductResponse
import com.example.myshopapp.R
import com.example.myshopapp.models.ProductModel
import kotlinx.android.synthetic.main.fragment_womens_fashion.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WomensFashionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WomensFashionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_womens_fashion, container, false)

        var mOrderList = ArrayList<ProductModel>()

        var adapter = ProductAdapter(mOrderList,requireContext())
        view.recyclerViewWomensFashion.adapter = adapter
        view.recyclerViewWomensFashion.layoutManager = GridLayoutManager(requireContext(),2,
            GridLayoutManager.VERTICAL,false)
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WomensFashionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WomensFashionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}