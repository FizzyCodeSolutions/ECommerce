package ecommerce.harminder.headyecommerceapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import ecommerce.harminder.headyecommerceapp.dao.CategoryDao;
import ecommerce.harminder.headyecommerceapp.entities.CategoriesPojo;
import ecommerce.harminder.headyecommerceapp.entities.converter.Converters;

@Database(entities = {CategoriesPojo.class},version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class CategoryDB extends RoomDatabase {
 
    public abstract CategoryDao categoryDao();
 
}