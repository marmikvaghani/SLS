
package com.example.loginactivity.model.today_comexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StartComplaintLocation {

    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("latitude")
    @Expose
    private String latitude;

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

}
