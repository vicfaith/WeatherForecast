package au.com.vicfaith.android.weatherforecast.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import au.com.vicfaith.android.weatherforecast.utils.GenericParcelable;
import au.com.vicfaith.android.weatherforecast.viewmodel.BaseViewModel;

public abstract class BaseActivity<T extends BaseViewModel> extends AppCompatActivity {

    public static final String EXTRA_VIEW_MODEL_STATE = "viewModelState";

    protected T viewModel;

    @Nullable
    protected abstract T createViewModel(@Nullable Bundle savedInstanceState);

    public T getViewModel() {
        return viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = createViewModel(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (viewModel != null) {
            GenericParcelable parcelable = new GenericParcelable(viewModel.getModelData());
            outState.putParcelable(EXTRA_VIEW_MODEL_STATE, parcelable);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (viewModel != null) {
            viewModel.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (viewModel != null) {
            viewModel.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (viewModel != null) {
            viewModel.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (viewModel != null) {
            viewModel.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (viewModel != null) {
            viewModel.onDestroy();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (viewModel != null) {
            viewModel.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}

