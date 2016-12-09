package au.com.vicfaith.android.weatherforecast.viewmodel;

import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.widget.TextView;

import au.com.vicfaith.android.weatherforecast.utils.MeteoconsConverter;
import au.com.vicfaith.android.weatherforecast.view.adapter.ForecastAdapter;

public class DailyForecast implements ForecastAdapter.ItemViewType {
    private String icon;
    private String date;
    private String summary;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @BindingAdapter({"app:text"})
    public static void loadMeteocon(TextView view, String text) {
        Typeface meteocons = Typeface.createFromAsset(view.getContext().getAssets(), "meteocons.ttf");
        view.setTypeface(meteocons);
        view.setText(MeteoconsConverter.from(text));
    }

    @Override
    public int getItemType() {
        return ForecastAdapter.ItemViewType.ITEM_TYPE_DAILY_FORECAST;
    }
}