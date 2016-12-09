package au.com.vicfaith.android.weatherforecast.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Forecast implements Serializable {
    @SerializedName("latitude")
    @Expose
    private double latitude;
    @SerializedName("longitude")
    @Expose
    private double longitude;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("offset")
    @Expose
    private int offset;
    @SerializedName("currently")
    @Expose
    private Currently currently;
    @SerializedName("minutely")
    @Expose
    private Minutely minutely;
    @SerializedName("hourly")
    @Expose
    private Hourly hourly;
    @SerializedName("daily")
    @Expose
    private Daily daily;
    @SerializedName("alerts")
    @Expose
    private List<Alert> alerts = new ArrayList<Alert>();
    @SerializedName("flags")
    @Expose
    private Flags flags;

    /**
     * @return The latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude The latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return The longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude The longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return The timezone
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * @param timezone The timezone
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     * @return The offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @param offset The offset
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * @return The currently
     */
    public Currently getCurrently() {
        return currently;
    }

    /**
     * @param currently The currently
     */
    public void setCurrently(Currently currently) {
        this.currently = currently;
    }

    /**
     * @return The minutely
     */
    public Minutely getMinutely() {
        return minutely;
    }

    /**
     * @param minutely The minutely
     */
    public void setMinutely(Minutely minutely) {
        this.minutely = minutely;
    }

    /**
     * @return The hourly
     */
    public Hourly getHourly() {
        return hourly;
    }

    /**
     * @param hourly The hourly
     */
    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    /**
     * @return The daily
     */
    public Daily getDaily() {
        return daily;
    }

    /**
     * @param daily The daily
     */
    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    /**
     * @return The alerts
     */
    public List<Alert> getAlerts() {
        return alerts;
    }

    /**
     * @param alerts The alerts
     */
    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    /**
     * @return The flags
     */
    public Flags getFlags() {
        return flags;
    }

    /**
     * @param flags The flags
     */
    public void setFlags(Flags flags) {
        this.flags = flags;
    }

}