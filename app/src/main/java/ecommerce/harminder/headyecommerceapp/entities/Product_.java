
package ecommerce.harminder.headyecommerceapp.entities;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product_ {

    @ColumnInfo(name="id")
    @Expose
    private Integer id;

    @SerializedName("view_count")
    @ColumnInfo(name="viewCount")
    @Expose
    private Integer viewCount;

    @SerializedName("order_count")
    @ColumnInfo(name="orderCount")
    @Expose
    private Integer orderCount;

    @ColumnInfo(name="shares")
    @Expose
    private Integer shares;





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

}
