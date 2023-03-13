
package com.example.loginactivity.model.total_com_ex;

import androidx.annotation.NonNull;

import java.util.List;

// import com.example.Datum;
import com.example.loginactivity.model.total_com_ex.Datum1;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("data")
    @Expose
    private List<Datum1> data = null;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public List<Datum1> getData() {
        return data;
    }

    public void setData(List<Datum1> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @NonNull
    @Override
    public String toString() {
        return "Example{" +
                "statusCode=" + statusCode +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
