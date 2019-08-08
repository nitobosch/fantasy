
package com.nito.fantasy.model.marca;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "android",
    "ios",
    "web"
})
public class DspId {

    @JsonProperty("android")
    private String android;
    @JsonProperty("ios")
    private String ios;
    @JsonProperty("web")
    private String web;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("android")
    public String getAndroid() {
        return android;
    }

    @JsonProperty("android")
    public void setAndroid(String android) {
        this.android = android;
    }

    @JsonProperty("ios")
    public String getIos() {
        return ios;
    }

    @JsonProperty("ios")
    public void setIos(String ios) {
        this.ios = ios;
    }

    @JsonProperty("web")
    public String getWeb() {
        return web;
    }

    @JsonProperty("web")
    public void setWeb(String web) {
        this.web = web;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
