package au.com.vicfaith.android.weatherforecast.network;

import java.util.concurrent.TimeUnit;

import au.com.vicfaith.android.weatherforecast.BuildConfig;
import au.com.vicfaith.android.weatherforecast.model.Forecast;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiClient {
    public static final String API_KEY = "6ba2796f17afd5fe09ba8e7027860f63";

    private Retrofit retrofit;
    private ApiService apiService;

    public RestApiClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public void fetchWeatherForecast(double longitude, double latitude, Callback callback) {
        Call<Forecast> call = apiService.getWeatherForecast(longitude, latitude);
        call.enqueue(callback);
    }
}