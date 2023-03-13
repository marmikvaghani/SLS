
package com.example;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Datum {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("cmp_id")
    @Expose
    private Integer cmpId;
    @SerializedName("partyName")
    @Expose
    private String partyName;
    @SerializedName("machineNo")
    @Expose
    private String machineNo;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("callBy")
    @Expose
    private String callBy;
    @SerializedName("logBy")
    @Expose
    private String logBy;
    @SerializedName("engineerName")
    @Expose
    private String engineerName;
    @SerializedName("supportEngineerName1")
    @Expose
    private String supportEngineerName1;
    @SerializedName("supportEngineerName2")
    @Expose
    private String supportEngineerName2;
    @SerializedName("supportEngineerName3")
    @Expose
    private String supportEngineerName3;
    @SerializedName("createDateAt")
    @Expose
    private String createDateAt;
    @SerializedName("createTimeAt")
    @Expose
    private String createTimeAt;
    @SerializedName("isCompleted")
    @Expose
    private Boolean isCompleted;
    @SerializedName("repeatComplaintNumber")
    @Expose
    private Integer repeatComplaintNumber;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCmpId() {
        return cmpId;
    }

    public void setCmpId(Integer cmpId) {
        this.cmpId = cmpId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getMachineNo() {
        return machineNo;
    }

    public void setMachineNo(String machineNo) {
        this.machineNo = machineNo;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCallBy() {
        return callBy;
    }

    public void setCallBy(String callBy) {
        this.callBy = callBy;
    }

    public String getLogBy() {
        return logBy;
    }

    public void setLogBy(String logBy) {
        this.logBy = logBy;
    }

    public String getEngineerName() {
        return engineerName;
    }

    public void setEngineerName(String engineerName) {
        this.engineerName = engineerName;
    }

    public String getSupportEngineerName1() {
        return supportEngineerName1;
    }

    public void setSupportEngineerName1(String supportEngineerName1) {
        this.supportEngineerName1 = supportEngineerName1;
    }

    public String getSupportEngineerName2() {
        return supportEngineerName2;
    }

    public void setSupportEngineerName2(String supportEngineerName2) {
        this.supportEngineerName2 = supportEngineerName2;
    }

    public String getSupportEngineerName3() {
        return supportEngineerName3;
    }

    public void setSupportEngineerName3(String supportEngineerName3) {
        this.supportEngineerName3 = supportEngineerName3;
    }

    public String getCreateDateAt() {
        return createDateAt;
    }

    public void setCreateDateAt(String createDateAt) {
        this.createDateAt = createDateAt;
    }

    public String getCreateTimeAt() {
        return createTimeAt;
    }

    public void setCreateTimeAt(String createTimeAt) {
        this.createTimeAt = createTimeAt;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Integer getRepeatComplaintNumber() {
        return repeatComplaintNumber;
    }

    public void setRepeatComplaintNumber(Integer repeatComplaintNumber) {
        this.repeatComplaintNumber = repeatComplaintNumber;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
