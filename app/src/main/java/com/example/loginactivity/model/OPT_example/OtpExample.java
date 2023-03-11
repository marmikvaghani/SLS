
package com.example.loginactivity.model.OPT_example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtpExample {

    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("engineerCity")
    @Expose
    private String engineerCity;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEngineerCity() {
        return engineerCity;
    }

    public void setEngineerCity(String engineerCity) {
        this.engineerCity = engineerCity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getstatusCode() {
        return statusCode;
    }
}
