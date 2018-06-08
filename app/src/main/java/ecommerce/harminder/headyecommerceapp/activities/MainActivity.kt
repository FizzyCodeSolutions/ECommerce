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
import ecommerce.harminder.headyecommerceapp.entities.Example
import retrofit2.Call
import retrofit2.Response


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
        val api = retrofit?.create(Api::class.java)
        val call = api.categoriesData

        call.enqueue(object : Callback<Example> {
            override fun onResponse(call: Call<Example>?, response: Response<Example>?) {
                val data = response?.body()

                Log.d("data", Gson().toJson(data))
                val heroList = data?.categories

                val heroes = arrayOfNulls<String>(heroList!!.size)

                for (i in heroList.indices) {
                    heroes[i] = heroList[i].name
                }
            }

            override fun onFailure(call: Call<Example>?, t: Throwable?) {
                Toast.makeText(applicationContext, t?.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
