package com.entersekt.mycity.repositories;

import android.os.AsyncTask;

import com.entersekt.mycity.MyApplication;
import com.entersekt.mycity.database.CityDao;
import com.entersekt.mycity.models.City;

import java.util.List;

public class DBRepo {

    private final CityDao mCityDao;
  //  private final ICityInterface mICityInterface;

    public DBRepo() {
       // mICityInterface = aICityInterface;
        mCityDao = MyApplication.appInstance.getDatabaseInstance().cityDao();
    }

    public void getAllCities() {
        GetAllCities task = new GetAllCities(mCityDao);
        task.execute();
    }

    private static class GetAllCities extends AsyncTask<String, Void, List<City>> {

        private final CityDao mCityDao;
      //  private final ICityInterface mIBookingInterface;

        GetAllCities(CityDao aCityDao ) {
            mCityDao = aCityDao;
         //  mIBookingInterface = aICityInterface;
        }

        @Override
        protected List<City> doInBackground(String... aLists) {
            return mCityDao.getCities();
        }

        @Override
        protected void onPostExecute(List<City> aCityListModels) {
            super.onPostExecute(aCityListModels);
           // mIBookingInterface.getAllCities(aCityListModels);
        }
    }

}
