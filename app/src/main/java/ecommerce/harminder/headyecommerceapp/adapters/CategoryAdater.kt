package ecommerce.harminder.headyecommerceapp.adapters

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ecommerce.harminder.headyecommerceapp.R
import ecommerce.harminder.headyecommerceapp.fragments.CategoryFragment
import ecommerce.harminder.headyecommerceapp.fragments.ProductsFragment
import ecommerce.harminder.headyecommerceapp.room.entities.Category
import kotlinx.android.synthetic.main.item_category.view.*
import java.util.*

class CategoryAdater(public var context: FragmentActivity, var categories: ArrayList<Category>) : RecyclerView.Adapter<CategoryAdater.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(categories[position], context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    private fun openFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(category: Category, context: FragmentActivity) {
            itemView.tvName.text = category.name
            itemView.tvId.text = category.id.toString()


            itemView.setOnClickListener {


                if (category.childCategories.isNotEmpty()) {
                    var fragChild = CategoryFragment()
                    fragChild.arguments = getBundleData(category, false)

                    context.supportFragmentManager.beginTransaction().replace(R.id.flContainer, fragChild).addToBackStack(fragChild.javaClass.canonicalName).commit()
                } else {

                    if (category.products.isEmpty())
                        Toast.makeText(context, context.getText(R.string.noProduct), Toast.LENGTH_LONG).show()
                    else {

                        var frag = ProductsFragment()
                        frag.arguments = getBundleData(category, false)

                        context.supportFragmentManager.beginTransaction().replace(R.id.flContainer, frag).addToBackStack("").commit()
                    }
                }
            }
        }

        private fun getBundleData(category: Category, isChild: Boolean): Bundle {
            var bundle = Bundle()
            bundle.putSerializable("data", category)
            bundle.putBoolean("isChild", isChild)

            return bundle
        }


    }
}