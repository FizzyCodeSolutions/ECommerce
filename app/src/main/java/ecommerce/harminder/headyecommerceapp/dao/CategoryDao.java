package ecommerce.harminder.headyecommerceapp.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

import ecommerce.harminder.headyecommerceapp.entities.CategoriesPojo;
import ecommerce.harminder.headyecommerceapp.entities.Category;

@Dao
public interface CategoryDao {

//    @Query("SELECT * FROM Category")
//    ArrayList<Category> getAll();

    @Query("SELECT * FROM CategoriesPojo")
    CategoriesPojo getCategoryPojo();

//    @Query("SELECT * FROM user where first_name LIKE  :firstName AND last_name LIKE :lastName")
//    User findByName(String firstName, String lastName);
//
//    @Query("SELECT COUNT(*) from user")
//    int countUsers();
//
    @Insert
    void insertAll(CategoriesPojo categoriesPojo);
//
//    @Delete
//    void delete(User user);
}