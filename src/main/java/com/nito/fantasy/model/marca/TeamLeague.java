
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
    "id",
    "money",
    "teamPoints",
    "playersNumber",
    "banned",
    "teamValue",
    "canPunctuate",
    "position",
    "isAdmin"
})
public class TeamLeague {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("money")
    private Integer money;
    @JsonProperty("teamPoints")
    private Integer teamPoints;
    @JsonProperty("playersNumber")
    private Integer playersNumber;
    @JsonProperty("banned")
    private Boolean banned;
    @JsonProperty("teamValue")
    private Integer teamValue;
    @JsonProperty("canPunctuate")
    private Boolean canPunctuate;
    @JsonProperty("position")
    private Object position;
    @JsonProperty("isAdmin")
    private Boolean isAdmin;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("money")
    public Integer getMoney() {
        return money;
    }

    @JsonProperty("money")
    public void setMoney(Integer money) {
        this.money = money;
    }

    @JsonProperty("teamPoints")
    public Integer getTeamPoints() {
        return teamPoints;
    }

    @JsonProperty("teamPoints")
    public void setTeamPoints(Integer teamPoints) {
        this.teamPoints = teamPoints;
    }

    @JsonProperty("playersNumber")
    public Integer getPlayersNumber() {
        return playersNumber;
    }

    @JsonProperty("playersNumber")
    public void setPlayersNumber(Integer playersNumber) {
        this.playersNumber = playersNumber;
    }

    @JsonProperty("banned")
    public Boolean getBanned() {
        return banned;
    }

    @JsonProperty("banned")
    public void setBanned(Boolean banned) {
        this.banned = banned;
    }

    @JsonProperty("teamValue")
    public Integer getTeamValue() {
        return teamValue;
    }

    @JsonProperty("teamValue")
    public void setTeamValue(Integer teamValue) {
        this.teamValue = teamValue;
    }

    @JsonProperty("canPunctuate")
    public Boolean getCanPunctuate() {
        return canPunctuate;
    }

    @JsonProperty("canPunctuate")
    public void setCanPunctuate(Boolean canPunctuate) {
        this.canPunctuate = canPunctuate;
    }

    @JsonProperty("position")
    public Object getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Object position) {
        this.position = position;
    }

    @JsonProperty("isAdmin")
    public Boolean getIsAdmin() {
        return isAdmin;
    }

    @JsonProperty("isAdmin")
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
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
