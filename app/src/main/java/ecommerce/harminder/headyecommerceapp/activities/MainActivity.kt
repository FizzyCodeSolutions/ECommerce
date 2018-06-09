package ecommerce.harminder.headyecommerceapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import ecommerce.harminder.headyecommerceapp.MyApplication
import ecommerce.harminder.headyecommerceapp.R
import ecommerce.harminder.headyecommerceapp.contract.CategoryContract
import ecommerce.harminder.headyecommerceapp.fragments.CategoryFragment
import ecommerce.harminder.headyecommerceapp.presenters.CategoryPresenter
import ecommerce.harminder.headyecommerceapp.room.entities.CategoriesPojo
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import javax.inject.Inject


class MainActivity : AppCompatActivity(), CategoryContract.View {


    @Inject
    lateinit var retrofit: Retrofit

    private lateinit var presenter: CategoryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication).netComponent.inject(this)

        setPresenter()

    }

    private fun setPresenter() {
        presenter = CategoryPresenter(retrofit, this, this)

        pb.visibility = View.VISIBLE
        presenter.apiFetchCategories()

    }


    override fun initiateFragment(data: CategoriesPojo?) {
        pb.visibility = View.GONE

        if (data == null)
            cancelWithError(getString(R.string.NoDataFound))
        else {
            var frag = fragWithBundle(data!!)
            supportFragmentManager.beginTransaction().replace(R.id.flContainer, frag).commit()
        }
    }

    private fun fragWithBundle(data: CategoriesPojo): CategoryFragment {
        var frag = CategoryFragment()

        var bundle = Bundle()
        bundle.putSerializable("data", data)
        frag.arguments = bundle
        return frag
    }

    override fun cancelWithError(error: String) {
        pb.visibility = View.GONE
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

}
