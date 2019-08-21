
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
    "stats",
    "weekNumber",
    "totalPoints"
})
public class PlayerStat {

    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("weekNumber")
    private Integer weekNumber;
    @JsonProperty("totalPoints")
    private Integer totalPoints;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @JsonProperty("weekNumber")
    public Integer getWeekNumber() {
        return weekNumber;
    }

    @JsonProperty("weekNumber")
    public void setWeekNumber(Integer weekNumber) {
        this.weekNumber = weekNumber;
    }

    @JsonProperty("totalPoints")
    public Integer getTotalPoints() {
        return totalPoints;
    }

    @JsonProperty("totalPoints")
    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
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
