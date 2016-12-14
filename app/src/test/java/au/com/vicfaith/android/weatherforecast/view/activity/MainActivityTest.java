package au.com.vicfaith.android.weatherforecast.view.activity;

import android.view.View;
import android.widget.ProgressBar;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import au.com.vicfaith.android.weatherforecast.BuildConfig;
import au.com.vicfaith.android.weatherforecast.R;
import au.com.vicfaith.android.weatherforecast.viewmodel.ForecastViewModel;

/**
 * Created by dkang on 14/12/2016.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class MainActivityTest {
    private MainActivity mainActivity;

    @Before
    public void setup() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void testActivityNotNull() throws Exception {
        Assert.assertNotNull(mainActivity);
    }

    @Test
    public void testProgressBarVisibility() throws Exception {
        ProgressBar progressBar = (ProgressBar) mainActivity.findViewById(R.id.progressBar);
        Assert.assertEquals(View.GONE, progressBar.getVisibility());

        ForecastViewModel viewModel = mainActivity.getViewModel();
        viewModel.setShowProgressBar(true);
        viewModel.notifyChange();

        Assert.assertEquals(View.VISIBLE, progressBar.getVisibility());
    }
}
