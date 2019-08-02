
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
    "date",
    "operation",
    "player",
    "money"
})
public class FantasyHistory {

    @JsonProperty("date")
    private String date;
    @JsonProperty("operation")
    private String operation;
    @JsonProperty("player")
    private PlayerHistory player;
    @JsonProperty("money")
    private Integer money;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("operation")
    public String getOperation() {
        return operation;
    }

    @JsonProperty("operation")
    public void setOperation(String operation) {
        this.operation = operation;
    }

    @JsonProperty("player")
    public PlayerHistory getPlayer() {
        return player;
    }

    @JsonProperty("player")
    public void setPlayer(PlayerHistory player) {
        this.player = player;
    }

    @JsonProperty("money")
    public Integer getMoney() {
        return money;
    }

    @JsonProperty("money")
    public void setMoney(Integer money) {
        this.money = money;
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
