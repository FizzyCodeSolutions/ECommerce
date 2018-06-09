package ecommerce.harminder.headyecommerceapp.presenters

import android.arch.persistence.room.Room
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import ecommerce.harminder.headyecommerceapp.contract.CategoryContract
import ecommerce.harminder.headyecommerceapp.database.CategoryDB
import ecommerce.harminder.headyecommerceapp.entities.CategoriesPojo
import ecommerce.harminder.headyecommerceapp.retrofit.Api
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class CategoryPresenter(var retrofit: Retrofit, var view: CategoryContract.View, var context: Context) : CategoryContract.Presenter {


    override fun apiFetchCategories() {
        val api = retrofit.create(Api::class.java)
        val call = api.categoriesData

        call.enqueue(object : Callback<CategoriesPojo> {
            override fun onResponse(call: Call<CategoriesPojo>?, response: Response<CategoriesPojo>?) {
                val data = response?.body()

                Log.d("data", Gson().toJson(data))

                storeInDatabase(data)
            }

            override fun onFailure(call: Call<CategoriesPojo>?, t: Throwable?) {
                view.cancelWithError(t?.message!!)

            }
        })
    }


    fun storeInDatabase(Categories: CategoriesPojo?) {
        var database = Room.databaseBuilder(context,
                CategoryDB::class.java, "Ecommerce.db")
                .build()

        launch {
            database?.categoryDao()?.insertAll(Categories)

            launch(UI) {
                view.initiateFragment()
            }

        }

    }
}