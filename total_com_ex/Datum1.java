
package com.example.loginactivity.model.total_com_ex;

import androidx.annotation.NonNull;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum1 {
        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("cmp_id")
        @Expose
        private String cmpId;
        @SerializedName("partyName")
        @Expose
        private String partyName;
        @SerializedName("partyCity")
        @Expose
        private String partyCity;
        @SerializedName("time")
        @Expose
        private String time;
        @SerializedName("engineerCity")
        @Expose
        private String engineerCity;
        @SerializedName("machineNo")
        @Expose
        private String machineNo;
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
        @SerializedName("upadateDateAt")
        @Expose
        private String upadateDateAt;
        @SerializedName("upadateTimeAt")
        @Expose
        private String upadateTimeAt;
        @SerializedName("isCompleted")
        @Expose
        private String isCompleted;
        @SerializedName("repeatComplaintNumber")
        @Expose
        private Integer repeatComplaintNumber;
        @SerializedName("machineType")
        @Expose
        private String machineType;
        @SerializedName("__v")
        @Expose
        private Integer v;
        @SerializedName("endTime")
        @Expose
        private String endTime;
        @SerializedName("startTime")
        @Expose
        private String startTime;
        @SerializedName("upadateAt")
        @Expose
        private String upadateAt;
        @SerializedName("details")
        @Expose
        private List<String> details;
        @SerializedName("rating")
        @Expose
        private String rating;
        @SerializedName("solution")
        @Expose
        private String solution;
        @SerializedName("details1")
        @Expose
        private String details1;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCmpId() {
            return cmpId;
        }

        public void setCmpId(String cmpId) {
            this.cmpId = cmpId;
        }

        public String getPartyName() {
            return partyName;
        }

        public void setPartyName(String partyName) {
            this.partyName = partyName;
        }

        public String getPartyCity() {
            return partyCity;
        }

        public void setPartyCity(String partyCity) {
            this.partyCity = partyCity;
        }

        public String getEngineerCity() {
            return engineerCity;
        }

        public void setEngineerCity(String engineerCity) {
            this.engineerCity = engineerCity;
        }

        public String getMachineNo() {
            return machineNo;
        }

        public void setMachineNo(String machineNo) {
            this.machineNo = machineNo;
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

        public String getUpadateDateAt() {
            return upadateDateAt;
        }

        public void setUpadateDateAt(String upadateDateAt) {
            this.upadateDateAt = upadateDateAt;
        }

        public String getUpadateTimeAt() {
            return upadateTimeAt;
        }

        public void setUpadateTimeAt(String upadateTimeAt) {
            this.upadateTimeAt = upadateTimeAt;
        }

        public String getIsCompleted() {
            return isCompleted;
        }

        public void setIsCompleted(String isCompleted) {
            this.isCompleted = isCompleted;
        }

    public String gettime(){
        return time;
    }
        public Integer getRepeatComplaintNumber() {
            return repeatComplaintNumber;
        }

        public void setRepeatComplaintNumber(Integer repeatComplaintNumber) {
            this.repeatComplaintNumber = repeatComplaintNumber;
        }

        public String getMachineType() {
            return machineType;
        }

        public void setMachineType(String machineType) {
            this.machineType = machineType;
        }

        public Integer getV() {
            return v;
        }

        public void setV(Integer v) {
            this.v = v;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getUpadateAt() {
            return upadateAt;
        }

        public void setUpadateAt(String upadateAt) {
            this.upadateAt = upadateAt;
        }

        public List<String> getDetails() {
            return details;
        }

        public void setDetails(List<String> details) {
            this.details = details;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getSolution() {
            return solution;
        }

        public void setSolution(String solution) {
            this.solution = solution;
        }

        public String getDetails1() {
            return details1;
        }

        public void setDetails1(String details1) {
            this.details1 = details1;
        }


    @NonNull
    @Override
    public String toString() {
        return "Datum1{" +
                "id='" + id + '\'' +
                ", cmpId=" + cmpId +
                ", partyName='" + partyName + '\'' +
                ", machineNo='" + machineNo + '\'' +
                ", machineType='" + machineType + '\'' +
                ", details='" + details + '\'' +
                ", callBy='" + callBy + '\'' +
                ", solution='" + solution + '\'' +
                ", logBy='" + logBy + '\'' +
                ", engineerName='" + engineerName + '\'' +
                ", time='" + time + '\'' +
                ", supportEngineerName1='" + supportEngineerName1 + '\'' +
                ", supportEngineerName2='" + supportEngineerName2 + '\'' +
                ", supportEngineerName3='" + supportEngineerName3 + '\'' +
                ", createDateAt='" + createDateAt + '\'' +
                ", createTimeAt='" + createTimeAt + '\'' +
                ", isCompleted=" + isCompleted +
                ", repeatComplaintNumber=" + repeatComplaintNumber +
                '}';
    }
}
