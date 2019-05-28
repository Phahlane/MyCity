package com.entersekt.mycity.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(foreignKeys = @ForeignKey(entity= City.class, parentColumns="city_id", childColumns="mall_id"))
public class Mall {
    @PrimaryKey
    @ColumnInfo(name = "mall_id")
    @SerializedName("id")
    @Expose
    private float id;

    @ColumnInfo(name = "mall_name")
    @SerializedName("name")
    @Expose
    private String name;

    @ColumnInfo(name = "city_id")
    private int cityId;

    @Ignore
    @SerializedName("shops")
    @Expose
    private List<Shop> shopList = null;


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }



    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
