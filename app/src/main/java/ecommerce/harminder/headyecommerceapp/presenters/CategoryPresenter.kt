package ecommerce.harminder.headyecommerceapp.presenters

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import ecommerce.harminder.headyecommerceapp.contract.CategoryContract
import ecommerce.harminder.headyecommerceapp.retrofit.Api
import ecommerce.harminder.headyecommerceapp.room.database.database
import ecommerce.harminder.headyecommerceapp.room.database.dbInstance
import ecommerce.harminder.headyecommerceapp.room.entities.CategoriesPojo
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class CategoryPresenter(var retrofit: Retrofit, var view: CategoryContract.View, var context: Context) : CategoryContract.Presenter {


    private var fragmentInitaited: Boolean = false

    init {

        database = dbInstance(context)
        launch {
            var dataDeferred = async() {
                database?.categoryDao()?.categoryPojo
            }

            var catgoryPojo = dataDeferred.await()

            if (catgoryPojo != null) {
                fragmentInitaited = true

                launch(UI) {
                    view.initiateFragment(catgoryPojo)
                }
            }
        }
    }

    override fun apiFetchCategories() {
        val api = retrofit.create(Api::class.java)
        val call = api.categoriesData

        call.enqueue(object : Callback<CategoriesPojo> {
            override fun onResponse(call: Call<CategoriesPojo>?, response: Response<CategoriesPojo>?) {
                val data = response?.body()

                Log.d("data", Gson().toJson(data))


                storeInDatabase(data)

                if (fragmentInitaited)
                    return

                view.initiateFragment(data)

            }

            override fun onFailure(call: Call<CategoriesPojo>?, t: Throwable?) {
                view.cancelWithError(t?.message!!)

            }
        })
    }


    fun storeInDatabase(Categories: CategoriesPojo?) {


        launch {
            database?.categoryDao()?.insertAll(Categories)
        }

    }
}