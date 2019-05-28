package com.entersekt.mycity.views;

import com.entersekt.mycity.models.CityResponse;

public interface CitiesInterface {


    void showProgressBar();
    void hideProgressBar();
    void displayCities(CityResponse cityResponse);
    void displayError(String s);
}
