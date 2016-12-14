package au.com.vicfaith.android.weatherforecast.viewmodel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import au.com.vicfaith.android.weatherforecast.BuildConfig;
import au.com.vicfaith.android.weatherforecast.MockFactory;
import au.com.vicfaith.android.weatherforecast.model.Forecast;

/**
 * Created by dkang on 14/12/2016.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class ForecastViewModelTest extends ViewModelTest<Forecast, ForecastViewModel> {
    @Override
    protected ForecastViewModel createViewModel(Forecast savedInstanceState) {
        ForecastViewModel viewModel = new ForecastViewModel(RuntimeEnvironment.application);
        if (savedInstanceState != null) {
            viewModel.setModelData(savedInstanceState);
        }
        return viewModel;
    }

    @Before
    public void setUp() {
        super.setUp();
        Forecast forecast = MockFactory.getMockForecast(RuntimeEnvironment.application);
        viewModel.setModelData(forecast);
    }

    @Test
    public void testRotation() {
        rotateDestroy();
        rotateCreate();
        assertEquals("Australia/Sydney", viewModel.getModelData().getTimezone());

        rotateDestroy();
        rotateCreate();
        assertEquals("Australia/Sydney", viewModel.getModelData().getTimezone());
    }
}
