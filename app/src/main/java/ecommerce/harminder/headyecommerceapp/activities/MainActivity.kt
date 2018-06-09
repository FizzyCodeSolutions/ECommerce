package ecommerce.harminder.headyecommerceapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import ecommerce.harminder.headyecommerceapp.CategoryFragment
import ecommerce.harminder.headyecommerceapp.MyApplication
import ecommerce.harminder.headyecommerceapp.R
import ecommerce.harminder.headyecommerceapp.contract.CategoryContract
import ecommerce.harminder.headyecommerceapp.database.CategoryDB
import ecommerce.harminder.headyecommerceapp.entities.CategoriesPojo
import ecommerce.harminder.headyecommerceapp.presenters.CategoryPresenter
import retrofit2.Retrofit
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.*


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


    override fun initiateFragment() {
        pb.visibility = View.GONE
        supportFragmentManager.beginTransaction().replace(R.id.flContainer, CategoryFragment()).commit()

    }

    override fun cancelWithError(error: String) {
        pb.visibility = View.GONE
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

}
