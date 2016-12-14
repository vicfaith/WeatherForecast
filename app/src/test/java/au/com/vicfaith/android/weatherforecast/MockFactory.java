package au.com.vicfaith.android.weatherforecast;

import android.content.Context;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;

import au.com.vicfaith.android.weatherforecast.model.Forecast;
import au.com.vicfaith.android.weatherforecast.viewmodel.CurrentForecast;
import au.com.vicfaith.android.weatherforecast.viewmodel.DailyForecast;

/**
 * Created by dkang on 13/12/2016.
 */
public class MockFactory {

    public static Forecast getMockForecast(Context context) {
        InputStream inputStream = context.getClass().getClassLoader().getResourceAsStream("forecast.json");
        return new Gson().fromJson(new InputStreamReader(inputStream), Forecast.class);
    }

    public static CurrentForecast getMockCurrentForecast() {
        CurrentForecast forecast = new CurrentForecast();
        forecast.setIcon("partly-cloudy-day");
        forecast.setTemperature("36.3");
        forecast.setSummary("Partly Cloudy");
        forecast.setNextHourForecast("Drizzle");
        forecast.setNext24HoursForecast("Sunny");
        return forecast;
    }

    public static DailyForecast getMockDailyForecast() {
        DailyForecast forecast = new DailyForecast();
        forecast.setIcon("clear-day");
        forecast.setDate("SUN");
        forecast.setSummary("Clear");
        return forecast;
    }
}
