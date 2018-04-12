package com.example.amal.weatherapp;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amal.weatherapp.data.Channel;
import com.example.amal.weatherapp.data.Item;
import com.example.amal.weatherapp.service.WeatherServiceCallback;
import com.example.amal.weatherapp.service.YahooWeatherService;

public class MainActivity extends AppCompatActivity implements WeatherServiceCallback {

    private ImageView weatherIconImageView;
    private TextView temperatureTextView;
    private TextView conditionTextView;
    private TextView locationTextView;

    private YahooWeatherService service;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherIconImageView = (ImageView)findViewById(R.id.weatherIconImageView);
        temperatureTextView = (TextView) findViewById(R.id.temperatureTextView);
        conditionTextView = (TextView) findViewById(R.id.conditionTextView);
        locationTextView = (TextView) findViewById(R.id.locationTextView);

        service = new YahooWeatherService(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        service.refreshWeather("Toronto, ON");

    }

    @Override
    public void serviceSuccess(Channel channel) {
        dialog.hide();

        Item item = channel.getItem();

        int resource = getResources().getIdentifier("drawable/icon_"+item.getCondition().getCode(), null, getPackageName());

        Drawable weatherIconDrawable = getResources().getDrawable(resource);

        weatherIconImageView.setImageDrawable(weatherIconDrawable);

        locationTextView.setText(service.getLocation());
        temperatureTextView.setText(item.getCondition().getTemperature()+"\u00B0");
        conditionTextView.setText(item.getCondition().getDescription());
    }

    @Override
    public void serviceFailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();

    }
}
