
package com.dash_example;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.json.bind.annotation.JsonbTransient;

@JsonbPropertyOrder({
    "statusCode",
    "allCompaint",
    "paddingCompaint",
    "completedCompaint",
    "repeatingCompaint"
})
@Generated("jsonschema2pojo")
public class DashExample {

    @JsonbProperty("statusCode")
    private Integer statusCode;
    @JsonbProperty("allCompaint")
    private Integer allCompaint;
    @JsonbProperty("paddingCompaint")
    private Integer paddingCompaint;
    @JsonbProperty("completedCompaint")
    private Integer completedCompaint;
    @JsonbProperty("repeatingCompaint")
    private Integer repeatingCompaint;
    @JsonbTransient
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonbProperty("statusCode")
    public Integer getStatusCode() {
        return statusCode;
    }

    @JsonbProperty("statusCode")
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @JsonbProperty("allCompaint")
    public Integer getAllCompaint() {
        return allCompaint;
    }

    @JsonbProperty("allCompaint")
    public void setAllCompaint(Integer allCompaint) {
        this.allCompaint = allCompaint;
    }

    @JsonbProperty("paddingCompaint")
    public Integer getPaddingCompaint() {
        return paddingCompaint;
    }

    @JsonbProperty("paddingCompaint")
    public void setPaddingCompaint(Integer paddingCompaint) {
        this.paddingCompaint = paddingCompaint;
    }

    @JsonbProperty("completedCompaint")
    public Integer getCompletedCompaint() {
        return completedCompaint;
    }

    @JsonbProperty("completedCompaint")
    public void setCompletedCompaint(Integer completedCompaint) {
        this.completedCompaint = completedCompaint;
    }

    @JsonbProperty("repeatingCompaint")
    public Integer getRepeatingCompaint() {
        return repeatingCompaint;
    }

    @JsonbProperty("repeatingCompaint")
    public void setRepeatingCompaint(Integer repeatingCompaint) {
        this.repeatingCompaint = repeatingCompaint;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
