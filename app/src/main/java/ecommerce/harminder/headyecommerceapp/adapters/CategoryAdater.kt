package ecommerce.harminder.headyecommerceapp.adapters

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ecommerce.harminder.headyecommerceapp.CategoryFragment
import ecommerce.harminder.headyecommerceapp.R
import ecommerce.harminder.headyecommerceapp.entities.Category
import ecommerce.harminder.headyecommerceapp.fragments.ProductsFragment
import kotlinx.android.synthetic.main.item_category.view.*
import java.util.ArrayList

class CategoryAdater(public var context: AppCompatActivity, var categories: ArrayList<Category>) : RecyclerView.Adapter<CategoryAdater.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(categories[position],context)
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

        fun bindItems(category: Category, context: AppCompatActivity) {
            itemView.tvName.text = category.name
            itemView.tvId.text = category.id.toString()


            itemView.setOnClickListener{


                if(category.childCategories.isNotEmpty())
                context.supportFragmentManager.beginTransaction().replace(R.id.flContainer,CategoryFragment())
                else {
                   var frag= ProductsFragment()
                    context.supportFragmentManager.beginTransaction().replace(R.id.flContainer, )
                }
            }
        }




      }
}