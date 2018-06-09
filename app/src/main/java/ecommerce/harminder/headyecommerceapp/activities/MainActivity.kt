package ecommerce.harminder.headyecommerceapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ecommerce.harminder.headyecommerceapp.R
import ecommerce.harminder.headyecommerceapp.retrofit.Api
import ecommerce.harminder.headyecommerceapp.MyApplication
import retrofit2.Callback
import retrofit2.Retrofit
import javax.inject.Inject
import android.widget.Toast
import com.google.gson.Gson
import ecommerce.harminder.headyecommerceapp.entities.CategoriesPojo
import retrofit2.Call
import retrofit2.Response
import android.arch.persistence.room.Room
import ecommerce.harminder.headyecommerceapp.database.CategoryDB
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication).netComponent.inject(this)

        getData();
    }

    private fun getData() {
        val api = retrofit.create(Api::class.java)
        val call = api.categoriesData

        call.enqueue(object : Callback<CategoriesPojo> {
            override fun onResponse(call: Call<CategoriesPojo>?, response: Response<CategoriesPojo>?) {
                val data = response?.body()

                Log.d("data", Gson().toJson(data))

                storeInDatabase(data)
            }

            override fun onFailure(call: Call<CategoriesPojo>?, t: Throwable?) {
                Toast.makeText(applicationContext, t?.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private var database: CategoryDB? = null

    private var categories: CategoriesPojo? = null

    private fun storeInDatabase(Categories: CategoriesPojo?) {
        database = Room.databaseBuilder(applicationContext,
                CategoryDB::class.java, "Ecommerce.db")
                .build()

        launch(UI) {

            val categoriesDeffered = async {
                database?.categoryDao()?.insertAll(Categories)
                database?.categoryDao()?.categoryPojo
            }
            categories = categoriesDeffered.await()


            updateUi(categories)


        }

    }

    private fun updateUi(categories: CategoriesPojo?) {
        tvMy.text = "sdsadsa"
    }
}
