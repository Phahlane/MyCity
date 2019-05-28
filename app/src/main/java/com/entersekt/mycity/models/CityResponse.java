package com.entersekt.mycity.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CityResponse {
    @SerializedName("cities")
    @Expose
    private List<City> results = null;
    private static CityResponse cityResponse = null;

    public static CityResponse getCityResponseInstance() {
        if(cityResponse==null){
            cityResponse = new CityResponse();
        }
        return cityResponse;
    }

    public CityResponse() {
        cityResponse = this;
    }

    public List<City> getResults() {
        return results;
    }

    public void setResults(List<City> results) {
        this.results = results;
    }
}
