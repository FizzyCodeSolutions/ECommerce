
package ecommerce.harminder.headyecommerceapp.entities;

import android.arch.persistence.room.ColumnInfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ranking {

    @ColumnInfo(name="ranking")
    @Expose
    private String ranking;


    @SerializedName("products")
    @Expose
    private List<Product_> products = null;

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public List<Product_> getProducts() {
        return products;
    }

    public void setProducts(List<Product_> products) {
        this.products = products;
    }

}
