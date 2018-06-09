package ecommerce.harminder.headyecommerceapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ecommerce.harminder.headyecommerceapp.R
import ecommerce.harminder.headyecommerceapp.activities.MainActivity
import ecommerce.harminder.headyecommerceapp.adapters.CategoryAdater
import ecommerce.harminder.headyecommerceapp.adapters.ChildCategoryAdater
import ecommerce.harminder.headyecommerceapp.room.entities.CategoriesPojo
import ecommerce.harminder.headyecommerceapp.room.entities.Category
import kotlinx.android.synthetic.main.frag_category.*

class CategoryFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getBundleData()

    }

    private lateinit var category: CategoriesPojo
    private lateinit var listChild: ArrayList<Int>
    private lateinit var childCategory: Category
    private lateinit var myTitle: String

    private fun getBundleData() {
        if (arguments != null && !arguments!!.isEmpty) {
            if (arguments!!.containsKey("isChild")) {
                childCategory = arguments!!.getSerializable("data") as Category
                listChild = childCategory.childCategories as ArrayList<Int>
                setChildCategoryAdapter()
                myTitle = getString(R.string.subCat) + childCategory.name
            } else {
                category = arguments!!.getSerializable("data") as CategoriesPojo
                setCategoryAdapter()
                myTitle = getString(R.string.allCat)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity)?.supportActionBar?.title = myTitle
    }

    private fun setCategoryAdapter() {
        rvCategory.layoutManager = GridLayoutManager(getContext(), 2)
        rvCategory.adapter = CategoryAdater(activity!!, category?.categories!!)
    }


    private fun setChildCategoryAdapter() {
        rvCategory.layoutManager = GridLayoutManager(getContext(), 2)
        rvCategory.adapter = ChildCategoryAdater(activity!!, listChild, childCategory)
    }

}