
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
    "2048x2225",
    "1024x1113",
    "512x556",
    "256x278",
    "128x139",
    "64x70"
})
public class Big {

    @JsonProperty("2048x2225")
    private String _2048x2225;
    @JsonProperty("1024x1113")
    private String _1024x1113;
    @JsonProperty("512x556")
    private String _512x556;
    @JsonProperty("256x278")
    private String _256x278;
    @JsonProperty("128x139")
    private String _128x139;
    @JsonProperty("64x70")
    private String _64x70;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("2048x2225")
    public String get2048x2225() {
        return _2048x2225;
    }

    @JsonProperty("2048x2225")
    public void set2048x2225(String _2048x2225) {
        this._2048x2225 = _2048x2225;
    }

    @JsonProperty("1024x1113")
    public String get1024x1113() {
        return _1024x1113;
    }

    @JsonProperty("1024x1113")
    public void set1024x1113(String _1024x1113) {
        this._1024x1113 = _1024x1113;
    }

    @JsonProperty("512x556")
    public String get512x556() {
        return _512x556;
    }

    @JsonProperty("512x556")
    public void set512x556(String _512x556) {
        this._512x556 = _512x556;
    }

    @JsonProperty("256x278")
    public String get256x278() {
        return _256x278;
    }

    @JsonProperty("256x278")
    public void set256x278(String _256x278) {
        this._256x278 = _256x278;
    }

    @JsonProperty("128x139")
    public String get128x139() {
        return _128x139;
    }

    @JsonProperty("128x139")
    public void set128x139(String _128x139) {
        this._128x139 = _128x139;
    }

    @JsonProperty("64x70")
    public String get64x70() {
        return _64x70;
    }

    @JsonProperty("64x70")
    public void set64x70(String _64x70) {
        this._64x70 = _64x70;
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
