package com.entersekt.mycity.services;

import com.entersekt.mycity.models.CityResponse;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;


public interface CityService {

    @Headers("Content-Type: application/json")
    @GET(".")
    Observable<CityResponse> getCitiesData();
}