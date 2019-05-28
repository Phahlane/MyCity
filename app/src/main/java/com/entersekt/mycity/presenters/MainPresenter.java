package com.entersekt.mycity.presenters;


import android.util.Log;

import com.entersekt.mycity.models.CityResponse;
import com.entersekt.mycity.services.CityService;
import com.entersekt.mycity.services.MyCityNetworkClient;
import com.entersekt.mycity.views.CitiesInterface;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class MainPresenter implements MainPresenterInterface {

    CitiesInterface mvi;
    private String TAG = "MainPresenter";

    public MainPresenter(CitiesInterface mvi) {
        this.mvi = mvi;
    }

    @Override
    public void getCities() {
        getObservable().subscribeWith(getObserver());
    }

    public Observable<CityResponse> getObservable(){

        Observable<CityResponse> observable= MyCityNetworkClient.getRetrofit().create(CityService.class)
                .getCitiesData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

    public DisposableObserver<CityResponse> getObserver(){
        return new DisposableObserver<CityResponse>() {

            @Override
            public void onNext(CityResponse cityResponse) {
                mvi.displayCities(cityResponse);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
                mvi.displayError("Error fetching city Data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
                mvi.hideProgressBar();
            }
        };
    }
}
