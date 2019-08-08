
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
    "2048x2048",
    "1024x1024",
    "512x512",
    "256x256",
    "128x128",
    "64x64"
})
public class Transparent {

    @JsonProperty("2048x2048")
    private String _2048x2048;
    @JsonProperty("1024x1024")
    private String _1024x1024;
    @JsonProperty("512x512")
    private String _512x512;
    @JsonProperty("256x256")
    private String _256x256;
    @JsonProperty("128x128")
    private String _128x128;
    @JsonProperty("64x64")
    private String _64x64;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("2048x2048")
    public String get2048x2048() {
        return _2048x2048;
    }

    @JsonProperty("2048x2048")
    public void set2048x2048(String _2048x2048) {
        this._2048x2048 = _2048x2048;
    }

    @JsonProperty("1024x1024")
    public String get1024x1024() {
        return _1024x1024;
    }

    @JsonProperty("1024x1024")
    public void set1024x1024(String _1024x1024) {
        this._1024x1024 = _1024x1024;
    }

    @JsonProperty("512x512")
    public String get512x512() {
        return _512x512;
    }

    @JsonProperty("512x512")
    public void set512x512(String _512x512) {
        this._512x512 = _512x512;
    }

    @JsonProperty("256x256")
    public String get256x256() {
        return _256x256;
    }

    @JsonProperty("256x256")
    public void set256x256(String _256x256) {
        this._256x256 = _256x256;
    }

    @JsonProperty("128x128")
    public String get128x128() {
        return _128x128;
    }

    @JsonProperty("128x128")
    public void set128x128(String _128x128) {
        this._128x128 = _128x128;
    }

    @JsonProperty("64x64")
    public String get64x64() {
        return _64x64;
    }

    @JsonProperty("64x64")
    public void set64x64(String _64x64) {
        this._64x64 = _64x64;
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
