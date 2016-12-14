package au.com.vicfaith.android.weatherforecast.viewmodel;


import android.databinding.Observable;

import junit.framework.TestCase;

import org.junit.Before;
import org.mockito.verification.VerificationMode;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * This class is based on below blog
 * https://medium.com/@hiBrianLee/writing-testable-android-mvvm-app-part-4-e2f83fc21d71#.fighuyfi5
 */

public abstract class ViewModelTest<T, ViewModelT extends BaseViewModel> extends TestCase {

    private T savedInstanceState;

    protected ViewModelT viewModel;
    protected Observable.OnPropertyChangedCallback onPropertyChangedCallback;

    protected abstract ViewModelT createViewModel(T savedInstanceState);

    @Before
    public void setUp() {
        savedInstanceState = null;
        onPropertyChangedCallback = mock(Observable.OnPropertyChangedCallback.class);
        viewModel = createViewModel(null);
        viewModel.addOnPropertyChangedCallback(onPropertyChangedCallback);
    }

    protected final void verifyChanged() {
        verify(onPropertyChangedCallback).onPropertyChanged(any(Observable.class), eq(0));
    }

    protected final void verifyPropertyChanged(int propertyId) {
        verify(onPropertyChangedCallback).onPropertyChanged(any(Observable.class), eq(propertyId));
    }

    protected final void verifyPropertyChanged(int propertyId, VerificationMode verificationMode) {
        verify(onPropertyChangedCallback, verificationMode).onPropertyChanged(any(Observable.class), eq(propertyId));
    }

    protected final void rotateDestroy() {
        savedInstanceState = (T) viewModel.getModelData();
        viewModel.removeOnPropertyChangedCallback(onPropertyChangedCallback);
        viewModel.onStop();
    }

    protected final void rotateCreate() {
        onPropertyChangedCallback = mock(Observable.OnPropertyChangedCallback.class);
        viewModel = createViewModel(savedInstanceState);
        viewModel.addOnPropertyChangedCallback(onPropertyChangedCallback);
        viewModel.onStart();
        savedInstanceState = null;
    }
}