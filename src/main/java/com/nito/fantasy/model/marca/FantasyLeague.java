
package com.nito.fantasy.model.marca;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.nito.fantasy.dto.League;
import com.nito.fantasy.dto.Ranking;
import com.nito.fantasy.util.Formatter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "dfp",
    "access",
    "type",
    "managersNumber",
    "name",
    "region",
    "isDuplicated",
    "isSecondRound",
    "token",
    "description",
    "team"
})
public class FantasyLeague {

    @JsonProperty("id")
    private String id;
    @JsonProperty("dfp")
    private Boolean dfp;
    @JsonProperty("access")
    private String access;
    @JsonProperty("type")
    private Type type;
    @JsonProperty("managersNumber")
    private Integer managersNumber;
    @JsonProperty("name")
    private String name;
    @JsonProperty("region")
    private Region region;
    @JsonProperty("isDuplicated")
    private Boolean isDuplicated;
    @JsonProperty("isSecondRound")
    private Boolean isSecondRound;
    @JsonProperty("token")
    private String token;
    @JsonProperty("description")
    private String description;
    @JsonProperty("team")
    private TeamLeague team;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("dfp")
    public Boolean getDfp() {
        return dfp;
    }

    @JsonProperty("dfp")
    public void setDfp(Boolean dfp) {
        this.dfp = dfp;
    }

    @JsonProperty("access")
    public String getAccess() {
        return access;
    }

    @JsonProperty("access")
    public void setAccess(String access) {
        this.access = access;
    }

    @JsonProperty("type")
    public Type getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Type type) {
        this.type = type;
    }

    @JsonProperty("managersNumber")
    public Integer getManagersNumber() {
        return managersNumber;
    }

    @JsonProperty("managersNumber")
    public void setManagersNumber(Integer managersNumber) {
        this.managersNumber = managersNumber;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("region")
    public Region getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(Region region) {
        this.region = region;
    }

    @JsonProperty("isDuplicated")
    public Boolean getIsDuplicated() {
        return isDuplicated;
    }

    @JsonProperty("isDuplicated")
    public void setIsDuplicated(Boolean isDuplicated) {
        this.isDuplicated = isDuplicated;
    }

    @JsonProperty("isSecondRound")
    public Boolean getIsSecondRound() {
        return isSecondRound;
    }

    @JsonProperty("isSecondRound")
    public void setIsSecondRound(Boolean isSecondRound) {
        this.isSecondRound = isSecondRound;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("team")
    public TeamLeague getTeam() {
        return team;
    }

    @JsonProperty("team")
    public void setTeam(TeamLeague team) {
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
    
    public League convertToDto() {
    	League league = new League();
    	league.setLeagueId(this.id);
    	league.setLeagueName(this.name);
    	return league;
    }

}
