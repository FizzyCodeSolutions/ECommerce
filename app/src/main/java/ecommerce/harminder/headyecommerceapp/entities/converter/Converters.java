package ecommerce.harminder.headyecommerceapp.entities.converter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import ecommerce.harminder.headyecommerceapp.entities.Category;
import ecommerce.harminder.headyecommerceapp.entities.Ranking;

public class Converters {

    @TypeConverter
    public static ArrayList<Category> fromString(String value) {
        Type listType = new TypeToken<ArrayList<Category>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }
 
    @TypeConverter
    public static String fromArrayList(ArrayList<Category> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }


    @TypeConverter
    public static ArrayList<Ranking> fromStringRanking(String value) {
        Type listType = new TypeToken<ArrayList<Category>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayListRanking(ArrayList<Ranking> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
