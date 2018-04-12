package com.example.amal.weatherapp.service;

import com.example.amal.weatherapp.data.Channel;

/**
 * Created by Amal on 2018-04-10.
 */

public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);

    void serviceFailure(Exception exception);
}
