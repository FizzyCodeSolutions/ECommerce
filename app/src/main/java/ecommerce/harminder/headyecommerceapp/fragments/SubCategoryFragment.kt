package ecommerce.harminder.headyecommerceapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ecommerce.harminder.headyecommerceapp.R
import ecommerce.harminder.headyecommerceapp.adapters.CategoryAdater
import ecommerce.harminder.headyecommerceapp.room.entities.CategoriesPojo
import kotlinx.android.synthetic.main.frag_category.*

class SubCategoryFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getBundleData()
        setAdapter()
    }


    private lateinit var category: CategoriesPojo

    private fun getBundleData() {
        if (arguments != null && !arguments!!.isEmpty) {
            category = arguments!!.getSerializable("data") as CategoriesPojo
        }
    }

    private fun setAdapter() {
        rvCategory.layoutManager = GridLayoutManager(getContext(), 2)
        rvCategory.adapter = CategoryAdater(activity!!, category?.categories!!)
    }

}