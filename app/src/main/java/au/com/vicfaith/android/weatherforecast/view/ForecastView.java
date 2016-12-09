package au.com.vicfaith.android.weatherforecast.view;

import android.content.Context;

import java.util.List;

import au.com.vicfaith.android.weatherforecast.view.adapter.ForecastAdapter;

public interface ForecastView {

    Context getContext();

    void showForecast(List<ForecastAdapter.ItemViewType> forecast);

    void showSnackBar(String msg);

}
