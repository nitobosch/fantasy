
package com.nito.fantasy.model;

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
    "big",
    "beat",
    "transparent"
})
public class Images {

    @JsonProperty("big")
    private Big big;
    @JsonProperty("beat")
    private Beat beat;
    @JsonProperty("transparent")
    private Transparent transparent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("big")
    public Big getBig() {
        return big;
    }

    @JsonProperty("big")
    public void setBig(Big big) {
        this.big = big;
    }

    @JsonProperty("beat")
    public Beat getBeat() {
        return beat;
    }

    @JsonProperty("beat")
    public void setBeat(Beat beat) {
        this.beat = beat;
    }

    @JsonProperty("transparent")
    public Transparent getTransparent() {
        return transparent;
    }

    @JsonProperty("transparent")
    public void setTransparent(Transparent transparent) {
        this.transparent = transparent;
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
