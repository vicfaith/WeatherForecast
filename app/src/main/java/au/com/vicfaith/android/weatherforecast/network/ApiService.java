package au.com.vicfaith.android.weatherforecast.network;

import au.com.vicfaith.android.weatherforecast.model.Forecast;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static au.com.vicfaith.android.weatherforecast.network.RestApiClient.API_KEY;

public interface ApiService {
    @GET(API_KEY + "/{longitude},{latitude}")
    Call<Forecast> getWeatherForecast(@Path("latitude") double latitude, @Path("longitude") double longitude);
}