package ecommerce.harminder.headyecommerceapp.retrofit;

import javax.inject.Singleton;

import dagger.Component;
import ecommerce.harminder.headyecommerceapp.activities.MainActivity;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {
    void inject(MainActivity activity);
}