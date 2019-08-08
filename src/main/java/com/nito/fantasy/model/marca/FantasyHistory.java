
package com.nito.fantasy.model.marca;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.nito.fantasy.model.dynamodb.FantasyPlayerHistoryDB;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "date",
    "operation",
    "player",
    "money"
})
public class FantasyHistory {

    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private LocalDateTime date;
    @JsonProperty("operation")
    private String operation;
    @JsonProperty("player")
    private PlayerHistory player;
    @JsonProperty("money")
    private Integer money;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("date")
    public LocalDateTime getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(LocalDateTime date) {
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
	
	public FantasyPlayerHistoryDB convertToEntityDB(String leagueId) {
		FantasyPlayerHistoryDB fantasyPlayer = new FantasyPlayerHistoryDB();
		fantasyPlayer.setPlayerId(this.player.getId());
		fantasyPlayer.setPlayerName(this.player.getNickname());
		fantasyPlayer.setLeagueId(leagueId);
		fantasyPlayer.setOperation(this.operation);
		fantasyPlayer.setMoney(this.money);
		fantasyPlayer.setDate(this.date);
		return fantasyPlayer;
	}

}
