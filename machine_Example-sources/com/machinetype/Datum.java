
package com.machinetype;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Datum {

    @SerializedName("machineType")
    @Expose
    private String machineType;
    @SerializedName("partsName")
    @Expose
    private String partsName;
    @SerializedName("partsQuantity")
    @Expose
    private Integer partsQuantity;
    @SerializedName("isWarranty")
    @Expose
    private String isWarranty;
    @SerializedName("partsPrice")
    @Expose
    private Integer partsPrice;

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getPartsName() {
        return partsName;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName;
    }

    public Integer getPartsQuantity() {
        return partsQuantity;
    }

    public void setPartsQuantity(Integer partsQuantity) {
        this.partsQuantity = partsQuantity;
    }

    public String getIsWarranty() {
        return isWarranty;
    }

    public void setIsWarranty(String isWarranty) {
        this.isWarranty = isWarranty;
    }

    public Integer getPartsPrice() {
        return partsPrice;
    }

    public void setPartsPrice(Integer partsPrice) {
        this.partsPrice = partsPrice;
    }

}
