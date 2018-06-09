package ecommerce.harminder.headyecommerceapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ecommerce.harminder.headyecommerceapp.R
import ecommerce.harminder.headyecommerceapp.activities.MainActivity
import ecommerce.harminder.headyecommerceapp.adapters.ProductsAdater
import ecommerce.harminder.headyecommerceapp.room.entities.Category
import ecommerce.harminder.headyecommerceapp.room.entities.Product
import kotlinx.android.synthetic.main.frag_category.*
import java.util.*

class ProductsFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getBundleData()
        setAdapter()
    }

    private lateinit var category: Category

    private fun getBundleData() {
        if (arguments != null && !arguments!!.isEmpty) {
            category = arguments!!.getSerializable("data") as Category
        }
    }


    override fun onResume() {
        super.onResume()

        (activity as MainActivity)?.supportActionBar?.title = category.name
    }

    private fun setAdapter() {
        rvCategory.layoutManager = LinearLayoutManager(getContext())
        rvCategory.adapter = ProductsAdater(activity as FragmentActivity, category.products!! as ArrayList<Product>)


    }

}
