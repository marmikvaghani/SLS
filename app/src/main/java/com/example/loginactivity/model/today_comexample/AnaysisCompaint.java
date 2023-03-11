
package com.example.loginactivity.model.today_comexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnaysisCompaint {

    @SerializedName("compId")
    @Expose
    private String compId;
    @SerializedName("supportEngName")
    @Expose
    private String supportEngName;
    @SerializedName("supportEngNameCreateDate")
    @Expose
    private String supportEngNameCreateDate;
    @SerializedName("anaId")
    @Expose
    private String anaId;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("solution")
    @Expose
    private String solution;
    @SerializedName("rating")
    @Expose
    private String rating;

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getSupportEngName() {
        return supportEngName;
    }

    public void setSupportEngName(String supportEngName) {
        this.supportEngName = supportEngName;
    }

    public String getSupportEngNameCreateDate() {
        return supportEngNameCreateDate;
    }

    public void setSupportEngNameCreateDate(String supportEngNameCreateDate) {
        this.supportEngNameCreateDate = supportEngNameCreateDate;
    }

    public String getAnaId() {
        return anaId;
    }

    public void setAnaId(String anaId) {
        this.anaId = anaId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

}
