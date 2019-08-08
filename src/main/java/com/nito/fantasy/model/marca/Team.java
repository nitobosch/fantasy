
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
    "managerWarned",
    "id",
    "manager",
    "banned",
    "teamValue",
    "teamPoints",
    "teamMoney",
    "isAdmin"
})
public class Team {

    @JsonProperty("managerWarned")
    private Boolean managerWarned;
    @JsonProperty("id")
    private String id;
    @JsonProperty("manager")
    private Manager manager;
    @JsonProperty("banned")
    private Boolean banned;
    @JsonProperty("teamValue")
    private Integer teamValue;
    @JsonProperty("teamPoints")
    private Integer teamPoints;
    @JsonProperty("teamMoney")
    private Integer teamMoney;
    @JsonProperty("isAdmin")
    private Boolean isAdmin;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("managerWarned")
    public Boolean getManagerWarned() {
        return managerWarned;
    }

    @JsonProperty("managerWarned")
    public void setManagerWarned(Boolean managerWarned) {
        this.managerWarned = managerWarned;
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

    @JsonProperty("teamMoney")
    public Integer getTeamMoney() {
        return teamMoney;
    }

    @JsonProperty("teamMoney")
    public void setTeamMoney(Integer teamMoney) {
        this.teamMoney = teamMoney;
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
