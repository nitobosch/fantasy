
package com.nito.fantasy.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.nito.fantasy.entity.Ranking;
import com.nito.fantasy.util.Formatter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "position",
    "previousPosition",
    "points",
    "team"
})
public class FantasyRanking {

    @JsonProperty("position")
    private Integer position;
    @JsonProperty("previousPosition")
    private Integer previousPosition;
    @JsonProperty("points")
    private Integer points;
    @JsonProperty("team")
    private Team team;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("position")
    public Integer getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Integer position) {
        this.position = position;
    }

    @JsonProperty("previousPosition")
    public Integer getPreviousPosition() {
        return previousPosition;
    }

    @JsonProperty("previousPosition")
    public void setPreviousPosition(Integer previousPosition) {
        this.previousPosition = previousPosition;
    }

    @JsonProperty("points")
    public Integer getPoints() {
        return points;
    }

    @JsonProperty("points")
    public void setPoints(Integer points) {
        this.points = points;
    }

    @JsonProperty("team")
    public Team getTeam() {
        return team;
    }

    @JsonProperty("team")
    public void setTeam(Team team) {
        this.team = team;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
    public Ranking convertToDto() {
    	Ranking ranking = new Ranking();
    	ranking.setTeamPoints(this.points);
    	ranking.setPosition(this.position);
    	ranking.setManagerName(this.team.getManager().getManagerName());
    	ranking.setTeamId(this.team.getId());
    	ranking.setTeamValue(this.team.getTeamValue());
    	ranking.setTeamMoney(this.team.getTeamMoney());
    	ranking.setTeamMoneyFormatted(Formatter.formatNumber(this.team.getTeamMoney()));
    	ranking.setTeamValueFormatted(Formatter.formatNumber(this.team.getTeamValue()));
    	return ranking;
    }

}
