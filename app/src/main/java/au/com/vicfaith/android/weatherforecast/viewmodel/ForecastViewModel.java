package au.com.vicfaith.android.weatherforecast.viewmodel;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import au.com.vicfaith.android.weatherforecast.location.LocationManager;
import au.com.vicfaith.android.weatherforecast.model.DataPointModel;
import au.com.vicfaith.android.weatherforecast.model.Forecast;
import au.com.vicfaith.android.weatherforecast.network.RestApiClient;
import au.com.vicfaith.android.weatherforecast.utils.DateFormatter;
import au.com.vicfaith.android.weatherforecast.utils.TemperatureFormatter;
import au.com.vicfaith.android.weatherforecast.view.activity.MainActivity;
import au.com.vicfaith.android.weatherforecast.view.adapter.ForecastAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static au.com.vicfaith.android.weatherforecast.location.LocationManager.PERMISSION_ACCESS_COARSE_LOCATION;

public class ForecastViewModel extends BaseViewModel<Forecast> implements LocationListener {
    private Context context;
    private LocationManager locationManager;
    private RestApiClient restApiClient;
    private List<ForecastAdapter.ItemViewType> items;

    private boolean showProgressBar;

    private Location lastLocation;

    public Location getLastLocation() {
        return lastLocation;
    }

    public ForecastViewModel(Context context) {
        this.context = context;
        locationManager = new LocationManager(context, this);
        restApiClient = new RestApiClient();
        items = Collections.emptyList();
    }

    @Override
    public void setModelData(Forecast modelData) {
        super.setModelData(modelData);
        setItems(modelData);
    }

    public List<ForecastAdapter.ItemViewType> getItems() {
        return items;
    }

    private void setItems(final Forecast forecast) {
        items = new ArrayList<>();

        // set current forecast
        CurrentForecast currentForecast = new CurrentForecast();
        currentForecast.setIcon(forecast.getCurrently().getIcon());
        currentForecast.setTemperature(TemperatureFormatter.format(forecast.getCurrently().getTemperature()));
        currentForecast.setSummary(forecast.getCurrently().getSummary());
        currentForecast.setNextHourForecast(forecast.getHourly().getSummary());
        currentForecast.setNext24HoursForecast(forecast.getDaily().getSummary());
        items.add(currentForecast);

        // set daily forecast
        for (DataPointModel item : forecast.getDaily().getData()) {
            DailyForecast dailyForecast = new DailyForecast();
            dailyForecast.setIcon(item.getIcon());
            dailyForecast.setDate(DateFormatter.getDate(item.getTime()));
            dailyForecast.setSummary(item.getSummary());
            items.add(dailyForecast);
        }
    }

    public boolean getShowProgressBar() {
        return showProgressBar;
    }

    public void setShowProgressBar(boolean show) {
        showProgressBar = show;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!locationManager.hasLocationPermission()) {
                ((AppCompatActivity) context).requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_ACCESS_COARSE_LOCATION);
                return;
            }
        }

        locationManager.connect();
        locationManager.checkLocationSettings(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(@NonNull LocationSettingsResult result) {
                final com.google.android.gms.common.api.Status status = result.getStatus();
                switch (status.getStatusCode()) {
                    case LocationSettingsStatusCodes.SUCCESS:
                        locationManager.getLocationUpdates();
                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        try {
                            status.startResolutionForResult((MainActivity) context, PERMISSION_ACCESS_COARSE_LOCATION);
                        } catch (IntentSender.SendIntentException e) {
                        }
                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        context.startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void onPause() {
        locationManager.disconnect();
    }

    public void fetchWeatherForecast(Location location) {
        showProgressBar();

        restApiClient.fetchWeatherForecast(location.getLongitude(), location.getLatitude(), new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                Forecast forecast = response.body();
                setModelData(forecast);
                hideProgressBar();
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {
                hideProgressBar();
            }
        });
    }

    private void showProgressBar() {
        showProgressBar = true;
        notifyChange();
    }

    private void hideProgressBar() {
        showProgressBar = false;
        notifyChange();
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            lastLocation = location;
            fetchWeatherForecast(location);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == PERMISSION_ACCESS_COARSE_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                locationManager.getLocationUpdates();
            }
        }
    }
}
