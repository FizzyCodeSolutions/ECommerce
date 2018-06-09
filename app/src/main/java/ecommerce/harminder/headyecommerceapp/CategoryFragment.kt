package ecommerce.harminder.headyecommerceapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ecommerce.harminder.headyecommerceapp.adapters.CategoryAdater
import kotlinx.android.synthetic.main.frag_category.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class CategoryFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_category, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
    }

    private fun setAdapter() {

        launch {
            var categoriesDeffered = async {
                dbInstance(getContext()!!).categoryDao()?.categoryPojo
            }

            var categories = categoriesDeffered.await()

            launch(UI) {
                rvCategory.layoutManager = GridLayoutManager(getContext(), 2)
                rvCategory.adapter = CategoryAdater(activity!!, categories?.categories!!)
            }
        }
    }

}