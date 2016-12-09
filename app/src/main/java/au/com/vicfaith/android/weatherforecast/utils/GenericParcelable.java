package au.com.vicfaith.android.weatherforecast.utils;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * https://rakitech.wordpress.com/2014/07/31/generic-parcelable-implementation/
 */
public class GenericParcelable<T> implements Parcelable {

    private T mValue;
    private static ClassLoader mClassLoader;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcelOut, int flags) {
        parcelOut.writeValue(mValue);
    }

    @SuppressWarnings("rawtypes")
    public static final Creator<GenericParcelable> CREATOR = new Creator<GenericParcelable>() {

        public GenericParcelable createFromParcel(Parcel in) {
            return new GenericParcelable(in);
        }

        public GenericParcelable[] newArray(int size) {
            return new GenericParcelable[size];
        }
    };

    public GenericParcelable(T value) {
        this.mValue = value;
        if (this.mValue != null)
            GenericParcelable.mClassLoader = value.getClass().getClassLoader();
    }

    @SuppressWarnings("unchecked")
    private GenericParcelable(Parcel parcelIn) {
        try {
            //reading the passed value
            mValue = (T) parcelIn.readValue(GenericParcelable.mClassLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //generic method of obtaining the parcel value
    public T getValue() {
        return mValue;
    }

}

