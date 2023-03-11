package com.example.loginactivity.model.DashBoard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DashExample {

    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("allCompaint")
    @Expose
    private Integer allCompaint;
    @SerializedName("paddingCompaint")
    @Expose
    private Integer paddingCompaint;
    @SerializedName("completedCompaint")
    @Expose
    private Integer completedCompaint;
    @SerializedName("repeatingCompaint")
    @Expose
    private Integer repeatingCompaint;
    @SerializedName("newComplaint")
    @Expose
    private Integer newComplaint;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getAllCompaint() {
        return allCompaint;
    }

    public void setAllCompaint(Integer allCompaint) {
        this.allCompaint = allCompaint;
    }

    public Integer getPaddingCompaint() {
        return paddingCompaint;
    }

    public void setPaddingCompaint(Integer paddingCompaint) {
        this.paddingCompaint = paddingCompaint;
    }

    public Integer getCompletedCompaint() {
        return completedCompaint;
    }

    public void setCompletedCompaint(Integer completedCompaint) {
        this.completedCompaint = completedCompaint;
    }

    public Integer getRepeatingCompaint() {
        return repeatingCompaint;
    }

    public void setRepeatingCompaint(Integer repeatingCompaint) {
        this.repeatingCompaint = repeatingCompaint;
    }

    public Integer getNewComplaint() {
        return newComplaint;
    }

    public void setNewComplaint(Integer newComplaint) {
        this.newComplaint = newComplaint;
    }

}