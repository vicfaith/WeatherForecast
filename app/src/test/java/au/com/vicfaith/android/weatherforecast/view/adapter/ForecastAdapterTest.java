package au.com.vicfaith.android.weatherforecast.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import au.com.vicfaith.android.weatherforecast.BuildConfig;
import au.com.vicfaith.android.weatherforecast.MockFactory;
import au.com.vicfaith.android.weatherforecast.model.Forecast;
import au.com.vicfaith.android.weatherforecast.view.activity.MainActivity;
import au.com.vicfaith.android.weatherforecast.viewmodel.ForecastViewModel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by dkang on 13/12/2016.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class ForecastAdapterTest {
    private ForecastViewModel forecastViewModel;
    private Forecast forecast;
    private ForecastAdapter adapter;

    @Before
    public void setUp() {
        Context context = RuntimeEnvironment.application;
        forecast = MockFactory.getMockForecast(context);
        forecastViewModel = new ForecastViewModel(context);

        adapter = new ForecastAdapter();
        RecyclerView recyclerView = mock(RecyclerView.class);
        when(recyclerView.getAdapter()).thenReturn(adapter);

        forecastViewModel.setModelData(forecast);
        MainActivity.setItems(recyclerView, forecastViewModel.getItems());
    }

    @Test
    public void testItemCount() {
        Assert.assertEquals(9, adapter.getItemCount());
    }

    @Test
    public void testItemViewType() {
        Assert.assertEquals(ForecastAdapter.ItemViewType.ITEM_TYPE_CURRENT_FORECAST, adapter.getItemViewType(0));
        for (int i = 1; i < adapter.getItemCount(); i++) {
            Assert.assertEquals(ForecastAdapter.ItemViewType.ITEM_TYPE_DAILY_FORECAST, adapter.getItemViewType(i));
        }
    }
}
