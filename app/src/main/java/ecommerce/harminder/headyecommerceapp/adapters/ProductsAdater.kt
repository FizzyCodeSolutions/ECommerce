package ecommerce.harminder.headyecommerceapp.adapters

import android.graphics.Color
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.wefika.flowlayout.FlowLayout
import ecommerce.harminder.headyecommerceapp.R
import ecommerce.harminder.headyecommerceapp.room.entities.Product
import kotlinx.android.synthetic.main.item_products.view.*
import java.util.*
import kotlin.collections.HashSet

class ProductsAdater(var context: FragmentActivity, var listProducts: ArrayList<Product>) : RecyclerView.Adapter<ProductsAdater.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(listProducts[position], context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_products, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listProducts.size
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(category: Product, context: FragmentActivity) {
            itemView.tvName.text = category.name
            itemView.tvId.text = category.id.toString()


            val hashSetColor = HashSet<String>()
            val hashSetSize = HashSet<String>()
            for (value in category.variants) {

                // for gettig unique colors
                if (value.color != null && !hashSetColor.contains(value.color)) {
                    hashSetColor.add(value.color)

                    val tv = getTextView(context)
                    tv.text = value.color

                    itemView.flColours.addView(tv)
                }


                // for gettig unique sizes

                if (value.size != null && !hashSetSize.contains(value.size)) {
                    hashSetSize.add(value.color)
                    val tv = getTextView(context)
                    tv.text = value.size.toString()

                    itemView.flSize.addView(tv)
                }


            }


            itemView.setOnClickListener {
            }

        }

        private fun getTextView(context: FragmentActivity): TextView {
            var tv = TextView(context)
            var layoutParam = FlowLayout.LayoutParams(FlowLayout.LayoutParams.WRAP_CONTENT, FlowLayout.LayoutParams.WRAP_CONTENT);
            layoutParam.setMargins(10, 10, 10, 10)
            tv.layoutParams = layoutParam

            tv.setTextColor(Color.WHITE)
            tv.freezesText = true
            tv.setBackgroundResource(R.drawable.rectangle_background_fb)

            return tv
        }


    }
}