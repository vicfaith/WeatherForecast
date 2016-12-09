package au.com.vicfaith.android.weatherforecast.view.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import au.com.vicfaith.android.weatherforecast.R;
import au.com.vicfaith.android.weatherforecast.databinding.ActivityMainBinding;
import au.com.vicfaith.android.weatherforecast.model.Forecast;
import au.com.vicfaith.android.weatherforecast.utils.GenericParcelable;
import au.com.vicfaith.android.weatherforecast.view.ForecastView;
import au.com.vicfaith.android.weatherforecast.view.adapter.ForecastAdapter;
import au.com.vicfaith.android.weatherforecast.viewmodel.ForecastViewModel;

public class MainActivity extends BaseActivity<ForecastViewModel> implements ForecastView {

    private ActivityMainBinding binding;

    private ForecastAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);

        setupView();

        if (savedInstanceState != null) {
            viewModel.showForecast(viewModel.getViewModelState());
        }
    }

    @Nullable
    protected ForecastViewModel createViewModel(@Nullable GenericParcelable parcelable) {
        viewModel = new ForecastViewModel(this);
        if (parcelable != null) {
            viewModel.setViewModelState((Forecast) parcelable.getValue());
        }
        return viewModel;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (viewModel != null) {
            GenericParcelable viewModelState = new GenericParcelable<>(viewModel.getViewModelState());
            outState.putParcelable(EXTRA_VIEW_MODEL_STATE, viewModelState);
        }
    }

    private void setupView() {
        setSupportActionBar(binding.toolbar);

        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ForecastAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public Context getContext() {
        return MainActivity.this;
    }

    @Override
    public void showSnackBar(String msg) {
        Snackbar.make(binding.lyRoot, msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showForecast(List<ForecastAdapter.ItemViewType> forecast) {
        adapter.clear();
        adapter.addAll(forecast);
        adapter.notifyDataSetChanged();
    }
}
