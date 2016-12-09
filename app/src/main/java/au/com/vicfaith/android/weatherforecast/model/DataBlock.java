package au.com.vicfaith.android.weatherforecast.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataBlock implements Serializable {
    @SerializedName("time")
    @Expose
    private int time;
    @SerializedName("precipIntensity")
    @Expose
    private double precipIntensity;
    @SerializedName("precipIntensityError")
    @Expose
    private double precipIntensityError;
    @SerializedName("precipProbability")
    @Expose
    private double precipProbability;
    @SerializedName("precipType")
    @Expose
    private String precipType;

    /**
     * @return The time
     */
    public int getTime() {
        return time;
    }

    /**
     * @param time The time
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * @return The precipIntensity
     */
    public double getPrecipIntensity() {
        return precipIntensity;
    }

    /**
     * @param precipIntensity The precipIntensity
     */
    public void setPrecipIntensity(double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    /**
     * @return The precipIntensityError
     */
    public double getPrecipIntensityError() {
        return precipIntensityError;
    }

    /**
     * @param precipIntensityError The precipIntensityError
     */
    public void setPrecipIntensityError(double precipIntensityError) {
        this.precipIntensityError = precipIntensityError;
    }

    /**
     * @return The precipProbability
     */
    public double getPrecipProbability() {
        return precipProbability;
    }

    /**
     * @param precipProbability The precipProbability
     */
    public void setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
    }

    /**
     * @return The precipType
     */
    public String getPrecipType() {
        return precipType;
    }

    /**
     * @param precipType The precipType
     */
    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

}

