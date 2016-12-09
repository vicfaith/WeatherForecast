package au.com.vicfaith.android.weatherforecast.viewmodel;

import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.widget.TextView;

import au.com.vicfaith.android.weatherforecast.utils.MeteoconsConverter;
import au.com.vicfaith.android.weatherforecast.view.adapter.ForecastAdapter;

public class CurrentForecast implements ForecastAdapter.ItemViewType {
    private String icon;
    private String temperature;
    private String summary;
    private String nextHourForecast;
    private String next24HoursForecast;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getNextHourForecast() {
        return nextHourForecast;
    }

    public void setNextHourForecast(String nextHourForecast) {
        this.nextHourForecast = nextHourForecast;
    }

    public String getNext24HoursForecast() {
        return next24HoursForecast;
    }

    public void setNext24HoursForecast(String next24HoursForecast) {
        this.next24HoursForecast = next24HoursForecast;
    }

    @BindingAdapter({"app:text"})
    public static void loadMeteocon(TextView view, String text) {
        Typeface meteocons = Typeface.createFromAsset(view.getContext().getAssets(), "meteocons.ttf");
        view.setTypeface(meteocons);
        view.setText(MeteoconsConverter.from(text));
    }

    @Override
    public int getItemType() {
        return ForecastAdapter.ItemViewType.ITEM_TYPE_CURRENT_FORECAST;
    }
}
