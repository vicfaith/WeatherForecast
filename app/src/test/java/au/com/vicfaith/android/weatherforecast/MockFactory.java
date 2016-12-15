package au.com.vicfaith.android.weatherforecast;

import android.content.Context;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;

import au.com.vicfaith.android.weatherforecast.model.Currently;
import au.com.vicfaith.android.weatherforecast.model.Daily;
import au.com.vicfaith.android.weatherforecast.model.Forecast;
import au.com.vicfaith.android.weatherforecast.model.Hourly;
import au.com.vicfaith.android.weatherforecast.viewmodel.CurrentForecast;
import au.com.vicfaith.android.weatherforecast.viewmodel.DailyForecast;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by dkang on 13/12/2016.
 */
public class MockFactory {

    public static Forecast getMockForecast(Context context) {
        InputStream inputStream = context.getClass().getClassLoader().getResourceAsStream("forecast.json");
        return new Gson().fromJson(new InputStreamReader(inputStream), Forecast.class);
    }

    public static Forecast getMockForecast() {
        Forecast forecast = new Forecast();

        Currently current = mock(Currently.class);
        when(current.getIcon()).thenReturn("Clear");
        when(current.getTemperature()).thenReturn(12.0);
        when(current.getSummary()).thenReturn("Clear");
        forecast.setCurrently(current);

        Hourly hourly = mock(Hourly.class);
        when(hourly.getSummary()).thenReturn("Clear");
        forecast.setHourly(hourly);

        Daily daily = mock(Daily.class);
        when(daily.getSummary()).thenReturn("Clear");
        forecast.setDaily(daily);

        return forecast;
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
