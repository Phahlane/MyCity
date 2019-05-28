package com.entersekt.mycity.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.entersekt.mycity.models.City;

import java.util.List;

@Dao
public interface CityDao {

    @Query("SELECT * FROM city")
    List<City> getCities();

    @Query("SELECT * FROM  city WHERE city_id LIKE :cityId")
    City getCityId(int cityId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<City> aCityList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCity(City aCity);

    @Query("DELETE FROM city")
    int deleteAllCities();

}
