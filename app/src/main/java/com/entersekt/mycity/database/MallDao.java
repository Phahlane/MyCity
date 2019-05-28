package com.entersekt.mycity.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.entersekt.mycity.models.Mall;

import java.util.List;

@Dao
public interface MallDao {

    @Query("SELECT * FROM mall")
    List<Mall> getMalls();

    @Query("SELECT * FROM  mall WHERE city_id LIKE :cityId")
    List<Mall> getMallByCityId(int cityId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Mall> aMallList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMall(Mall aMall);

    @Query("DELETE FROM mall")
    int deleteAllMalls();

}
