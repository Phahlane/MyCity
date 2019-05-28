package com.entersekt.mycity.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(foreignKeys = @ForeignKey(entity= Mall.class, parentColumns="mall_id", childColumns="shop_id"))
public class Shop {

    @PrimaryKey
    @ColumnInfo(name = "shop_id")
    @SerializedName("id")
    @Expose
    private float id;

    @ColumnInfo(name = "shop_name")
    @SerializedName("name")
    @Expose
    private String name;


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
}