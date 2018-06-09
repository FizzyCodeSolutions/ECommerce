package ecommerce.harminder.headyecommerceapp.retrofit;

import ecommerce.harminder.headyecommerceapp.room.entities.CategoriesPojo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET(".")
    Call<CategoriesPojo> getCategoriesData();
}