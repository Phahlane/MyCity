package com.entersekt.mycity.database;

import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.entersekt.mycity.models.City;
import com.entersekt.mycity.models.Mall;
import com.entersekt.mycity.models.Shop;


@Database(entities = {City.class, Mall.class, Shop.class},version = 1, exportSchema = false)
public abstract class CitiesDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "CitiesDatabase";
    private static CitiesDatabase mInstance;
    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public static CitiesDatabase getDatabaseInstance(Context aContext) {
        if (mInstance == null) {
            synchronized (CitiesDatabase.class) {
                if (mInstance == null) {
                    mInstance = buildDatabase(aContext.getApplicationContext());
                    mInstance.updateDatabaseCreated(aContext.getApplicationContext());
                }
            }
        }
        return mInstance;
    }

    private static CitiesDatabase buildDatabase(final Context appContext) {
        return Room.databaseBuilder(appContext, CitiesDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

    private void updateDatabaseCreated(final Context context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated();
        }
    }

    private void setDatabaseCreated() {
        mIsDatabaseCreated.postValue(true);
    }

    public abstract CityDao cityDao();

    public abstract MallDao mallDao();

    public abstract ShopDao shopDao();

}
