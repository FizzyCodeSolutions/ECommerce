package ecommerce.harminder.headyecommerceapp.room.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.List;

@Entity
public class Product implements Serializable {

    @PrimaryKey()
    private Integer id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "date_added")
    private String dateAdded;

    @ColumnInfo(name = "variants")
    private List<Variant> variants = null;

    @ColumnInfo(name = "tax")
    private Tax tax;


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

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

}
