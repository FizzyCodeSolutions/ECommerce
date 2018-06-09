package ecommerce.harminder.headyecommerceapp.adapters

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ecommerce.harminder.headyecommerceapp.R
import ecommerce.harminder.headyecommerceapp.fragments.ProductsFragment
import ecommerce.harminder.headyecommerceapp.room.entities.Category
import kotlinx.android.synthetic.main.item_category.view.*

class ChildCategoryAdater(public var context: FragmentActivity, var categories: ArrayList<Int>, var childCategory: Category) : RecyclerView.Adapter<ChildCategoryAdater.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(categories[position], context, childCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(category: Int, context: FragmentActivity, childCategory: Category) {
            itemView.tvName.text = "No Name"
            itemView.tvId.text = category.toString()



            itemView.setOnClickListener {

                if (childCategory.products.isEmpty())
                    Toast.makeText(context, context.getText(R.string.noProduct), Toast.LENGTH_LONG).show()
                else {
                    var frag = ProductsFragment()
                    var bundle = Bundle()
                    bundle.putSerializable("data", childCategory)

                    frag.arguments = bundle

                    context.supportFragmentManager.beginTransaction().replace(R.id.flContainer, frag).addToBackStack("").commit()
                }
            }


        }
    }


}