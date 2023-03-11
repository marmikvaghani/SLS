package com.example.loginactivity;

import androidx.appcompat.app.AlertDialog;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("statusCode")
    @Expose
    private String statusCode;
    @SerializedName("message")
    @Expose
    private String  message;

    @SerializedName("token")
    @Expose
    private String  token;


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getstatusCode() {
        return statusCode;
    }

    public void setstatusCode(String statusCode) {
        this.statusCode = statusCode;
    }


    @Override
    public String toString() {
        return "Datum{" +
                "statusCode='" + statusCode + '\'' +
                ", message='" + message + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

}
