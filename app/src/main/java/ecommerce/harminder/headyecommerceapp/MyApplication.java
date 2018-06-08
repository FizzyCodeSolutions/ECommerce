package ecommerce.harminder.headyecommerceapp;

import android.app.Application;

import ecommerce.harminder.headyecommerceapp.retrofit.ApiComponent;
import ecommerce.harminder.headyecommerceapp.retrofit.ApiModule;
import ecommerce.harminder.headyecommerceapp.retrofit.AppModule;
import ecommerce.harminder.headyecommerceapp.retrofit.DaggerApiComponent;

public class MyApplication extends Application {

    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("https://stark-spire-93433.herokuapp.com/json/"))
                .build();
    }

    public ApiComponent getNetComponent() {
        return mApiComponent;
    }
}