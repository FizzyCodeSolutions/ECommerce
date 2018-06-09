package ecommerce.harminder.headyecommerceapp.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import ecommerce.harminder.headyecommerceapp.room.entities.CategoriesPojo;

@Dao
public interface CategoryDao {

//    @Query("SELECT * FROM Category")
//    ArrayList<Category> getAll();

    @Query("SELECT * FROM CategoriesPojo")
    CategoriesPojo getCategoryPojo();

    //    @Query("SELECT * FROM user where first_name LIKE  :firstName AND last_name LIKE :lastName")
//    User findByName(String firstName, String lastName);
//
    @Query("SELECT COUNT(*) FROM CategoriesPojo")
    int countCategories();

    //
    @Insert
    void insertAll(CategoriesPojo categoriesPojo);
//
//    @Delete
//    void delete(User user);
}