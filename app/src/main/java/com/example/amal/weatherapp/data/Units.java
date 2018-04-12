package com.example.amal.weatherapp.data;

import org.json.JSONObject;

/**
 * Created by Amal on 2018-04-10.
 */

public class Units implements JSONPopulator{

    private String temperature;

    public String getTemperature() {
        return temperature;
    }

    @Override
    public void populate(JSONObject data) {
        temperature = data.optString("temperature");
    }
}
