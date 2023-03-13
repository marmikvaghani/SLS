
package com.today_comexample;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class EndComplaintLocation {

    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("longitude")
    @Expose
    private Object longitude;
    @SerializedName("latitude")
    @Expose
    private Object latitude;

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Object getLongitude() {
        return longitude;
    }

    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    public Object getLatitude() {
        return latitude;
    }

    public void setLatitude(Object latitude) {
        this.latitude = latitude;
    }

}
