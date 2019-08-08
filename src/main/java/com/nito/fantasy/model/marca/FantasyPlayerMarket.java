
package com.nito.fantasy.model.marca;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lfpId",
    "marketValue",
    "date"
})
public class FantasyPlayerMarket {

    @JsonProperty("lfpId")
    private Integer lfpId;
    @JsonProperty("marketValue")
    private Integer marketValue;
    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private LocalDateTime date;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("lfpId")
    public Integer getLfpId() {
        return lfpId;
    }

    @JsonProperty("lfpId")
    public void setLfpId(Integer lfpId) {
        this.lfpId = lfpId;
    }

    @JsonProperty("marketValue")
    public Integer getMarketValue() {
        return marketValue;
    }

    @JsonProperty("marketValue")
    public void setMarketValue(Integer marketValue) {
        this.marketValue = marketValue;
    }

    @JsonProperty("date")
    public LocalDateTime getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(LocalDateTime date) {
        this.date = date;
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
