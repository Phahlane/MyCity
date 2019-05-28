package com.entersekt.mycity.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "City")
public class City {

    @PrimaryKey
    @ColumnInfo(name = "city_id")
    @SerializedName("id")
    @Expose
    private float id;
    @ColumnInfo(name = "city_name")
    @SerializedName("name")
    @Expose
    private String name;

    @Ignore
    @SerializedName("malls")
    @Expose
    private List<Mall> mallArrayList = null;

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

    public List<Mall> getMallArrayList() {
        return mallArrayList;
    }

    public void setMallArrayList(List<Mall> mallArrayList) {
        this.mallArrayList = mallArrayList;
    }
    
    public List<Shop> getAllShopsInTheCity(){
        List<Shop> shopList = new ArrayList<Shop>() ;
        
        if(mallArrayList !=null){
            for (Mall mall : mallArrayList
                 ) {
                shopList.addAll(mall.getShopList());
            }
        }

        return shopList;
    }
}

