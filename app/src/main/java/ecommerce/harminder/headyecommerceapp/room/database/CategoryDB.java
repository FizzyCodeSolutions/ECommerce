package ecommerce.harminder.headyecommerceapp.room.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import ecommerce.harminder.headyecommerceapp.room.dao.CategoryDao;
import ecommerce.harminder.headyecommerceapp.room.entities.CategoriesPojo;
import ecommerce.harminder.headyecommerceapp.room.entities.converter.Converters;

@Database(entities = {CategoriesPojo.class}, version = 2, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class CategoryDB extends RoomDatabase {

    public abstract CategoryDao categoryDao();

}