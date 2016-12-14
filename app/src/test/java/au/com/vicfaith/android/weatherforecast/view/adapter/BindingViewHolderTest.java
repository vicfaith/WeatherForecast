package au.com.vicfaith.android.weatherforecast.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import au.com.vicfaith.android.weatherforecast.BR;
import au.com.vicfaith.android.weatherforecast.BuildConfig;
import au.com.vicfaith.android.weatherforecast.MockFactory;
import au.com.vicfaith.android.weatherforecast.R;
import au.com.vicfaith.android.weatherforecast.model.Forecast;
import au.com.vicfaith.android.weatherforecast.view.activity.MainActivity;
import au.com.vicfaith.android.weatherforecast.viewmodel.CurrentForecast;
import au.com.vicfaith.android.weatherforecast.viewmodel.DailyForecast;
import au.com.vicfaith.android.weatherforecast.viewmodel.ForecastViewModel;

/**
 * Created by dkang on 13/12/2016.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class BindingViewHolderTest {
    private Activity activity;

    @Before
    public void setUp() {
        Context context = RuntimeEnvironment.application;
        Forecast forecast = MockFactory.getMockForecast(context);
        ForecastViewModel forecastViewModel = new ForecastViewModel(context);
        forecastViewModel.setModelData(forecast);
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
    }

    @Test
    public void testBindCurrentForecastView() {
        View view = LayoutInflater.from(activity).inflate(R.layout.current_forecast_item, null);
        BindingViewHolder holder = new BindingViewHolder(view);
        CurrentForecast forecast = MockFactory.getMockCurrentForecast();
        holder.getBinding().setVariable(BR.viewModel, forecast);
        holder.getBinding().executePendingBindings();

        TextView textView = (TextView) view.findViewById(R.id.icon);
        Assert.assertEquals("H", textView.getText());

        textView = (TextView) view.findViewById(R.id.temperature);
        Assert.assertEquals("36.3", textView.getText());

        textView = (TextView) view.findViewById(R.id.summary);
        Assert.assertEquals("Partly Cloudy", textView.getText());

        textView = (TextView) view.findViewById(R.id.nextHourForecast);
        Assert.assertEquals("Drizzle", textView.getText());

        textView = (TextView) view.findViewById(R.id.next24HoursForecast);
        Assert.assertEquals("Sunny", textView.getText());
    }

    @Test
    public void testBindDailyForecastView() {
        View view = LayoutInflater.from(activity).inflate(R.layout.daily_forecast_item, null);
        BindingViewHolder holder = new BindingViewHolder(view);
        DailyForecast forecast = MockFactory.getMockDailyForecast();
        holder.getBinding().setVariable(BR.viewModel, forecast);
        holder.getBinding().executePendingBindings();

        TextView textView = (TextView) view.findViewById(R.id.icon);
        Assert.assertEquals("B", textView.getText());

        textView = (TextView) view.findViewById(R.id.date);
        Assert.assertEquals("SUN", textView.getText());

        textView = (TextView) view.findViewById(R.id.summary);
        Assert.assertEquals("Clear", textView.getText());
    }
}