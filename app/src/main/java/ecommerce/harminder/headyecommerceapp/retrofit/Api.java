package ecommerce.harminder.headyecommerceapp.retrofit;

import java.util.ArrayList;

import ecommerce.harminder.headyecommerceapp.entities.Category;
import ecommerce.harminder.headyecommerceapp.entities.Example;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET(".")
    Call<Example> getCategoriesData();
}