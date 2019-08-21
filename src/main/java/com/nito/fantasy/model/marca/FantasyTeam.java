
package com.nito.fantasy.model.marca;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "players",
    "teamMoney",
    "id",
    "manager",
    "startingWeek",
    "banned",
    "teamValue",
    "teamPoints",
    "position",
    "fixture_points",
    "previousPosition"
})
public class FantasyTeam {

    @JsonProperty("players")
    private List<Player> players = null;
    @JsonProperty("teamMoney")
    private Object teamMoney;
    @JsonProperty("id")
    private String id;
    @JsonProperty("manager")
    private Manager manager;
    @JsonProperty("startingWeek")
    private String startingWeek;
    @JsonProperty("banned")
    private Boolean banned;
    @JsonProperty("teamValue")
    private Integer teamValue;
    @JsonProperty("teamPoints")
    private Integer teamPoints;
    @JsonProperty("position")
    private Integer position;
    @JsonProperty("fixture_points")
    private Integer fixturePoints;
    @JsonProperty("previousPosition")
    private Integer previousPosition;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("players")
    public List<Player> getPlayers() {
        return players;
    }

    @JsonProperty("players")
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @JsonProperty("teamMoney")
    public Object getTeamMoney() {
        return teamMoney;
    }

    @JsonProperty("teamMoney")
    public void setTeamMoney(Object teamMoney) {
        this.teamMoney = teamMoney;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("manager")
    public Manager getManager() {
        return manager;
    }

    @JsonProperty("manager")
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @JsonProperty("startingWeek")
    public String getStartingWeek() {
        return startingWeek;
    }

    @JsonProperty("startingWeek")
    public void setStartingWeek(String startingWeek) {
        this.startingWeek = startingWeek;
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

    @JsonProperty("teamPoints")
    public Integer getTeamPoints() {
        return teamPoints;
    }

    @JsonProperty("teamPoints")
    public void setTeamPoints(Integer teamPoints) {
        this.teamPoints = teamPoints;
    }

    @JsonProperty("position")
    public Integer getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Integer position) {
        this.position = position;
    }

    @JsonProperty("fixture_points")
    public Integer getFixturePoints() {
        return fixturePoints;
    }

    @JsonProperty("fixture_points")
    public void setFixturePoints(Integer fixturePoints) {
        this.fixturePoints = fixturePoints;
    }

    @JsonProperty("previousPosition")
    public Integer getPreviousPosition() {
        return previousPosition;
    }

    @JsonProperty("previousPosition")
    public void setPreviousPosition(Integer previousPosition) {
        this.previousPosition = previousPosition;
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
