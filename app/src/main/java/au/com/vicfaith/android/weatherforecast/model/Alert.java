package au.com.vicfaith.android.weatherforecast.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Alert implements Serializable {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("time")
    @Expose
    private int time;
    @SerializedName("expires")
    @Expose
    private int expires;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("uri")
    @Expose
    private String uri;

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

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
     * @return The expires
     */
    public int getExpires() {
        return expires;
    }

    /**
     * @param expires The expires
     */
    public void setExpires(int expires) {
        this.expires = expires;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * @param uri The uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

}
