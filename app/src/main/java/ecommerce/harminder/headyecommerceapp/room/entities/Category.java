package ecommerce.harminder.headyecommerceapp.room.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "Category")
public class Category implements Serializable {

    @ColumnInfo(name = "id")
    @Expose
    private Integer id;

    @ColumnInfo(name = "name")
    @Expose
    private String name;

    @ColumnInfo(name = "products")
    @Expose
    private List<Product> products = null;

    @SerializedName("child_categories")
    @ColumnInfo(name = "child_categories")
    @Expose
    private List<Integer> childCategories = null;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Integer> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(List<Integer> childCategories) {
        this.childCategories = childCategories;
    }

}
