package au.com.vicfaith.android.weatherforecast.viewmodel;

import android.databinding.BaseObservable;

public abstract class BaseViewModel<T> extends BaseObservable {
    private T modelData;

    public T getModelData() {
        return modelData;
    }

    public void setModelData(T modelData) {
        this.modelData = modelData;
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

    }
}
