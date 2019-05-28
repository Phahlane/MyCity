package com.entersekt.mycity.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.entersekt.mycity.models.Shop;

import java.util.List;


@Dao
public interface ShopDao {

    @Query("SELECT * FROM shop")
    List<Shop> getShops();

    @Query("SELECT * FROM  shop WHERE shop_id LIKE :shopId")
    Shop getShopId(int shopId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Shop> aShopList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertShop(Shop aShop);

    @Query("DELETE FROM shop")
    int deleteAllShops();

}
