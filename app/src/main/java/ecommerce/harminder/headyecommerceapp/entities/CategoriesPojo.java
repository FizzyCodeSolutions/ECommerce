
package ecommerce.harminder.headyecommerceapp.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "CategoriesPojo")
public class CategoriesPojo {

    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name="categories")
    @Expose
    private ArrayList<Category> categories = null;

    @ColumnInfo(name="rankings")
    @Expose
    private ArrayList<Ranking> rankings = null;

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public ArrayList<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(ArrayList<Ranking> rankings) {
        this.rankings = rankings;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
