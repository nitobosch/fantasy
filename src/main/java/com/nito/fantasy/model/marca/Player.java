
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
import com.nito.fantasy.model.dynamodb.FantasyPlayerHistoryDB;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "playerMaster",
    "buyoutClause",
    "playerTeamId",
    "buyoutClauseLockedEndTime"
})
public class Player {

    @JsonProperty("playerMaster")
    private PlayerMaster playerMaster;
    @JsonProperty("buyoutClause")
    private Integer buyoutClause;
    @JsonProperty("playerTeamId")
    private String playerTeamId;
    @JsonProperty("buyoutClauseLockedEndTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private LocalDateTime buyoutClauseLockedEndTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("playerMaster")
    public PlayerMaster getPlayerMaster() {
        return playerMaster;
    }

    @JsonProperty("playerMaster")
    public void setPlayerMaster(PlayerMaster playerMaster) {
        this.playerMaster = playerMaster;
    }

    @JsonProperty("buyoutClause")
    public Integer getBuyoutClause() {
        return buyoutClause;
    }

    @JsonProperty("buyoutClause")
    public void setBuyoutClause(Integer buyoutClause) {
        this.buyoutClause = buyoutClause;
    }

    @JsonProperty("playerTeamId")
    public String getPlayerTeamId() {
        return playerTeamId;
    }

    @JsonProperty("playerTeamId")
    public void setPlayerTeamId(String playerTeamId) {
        this.playerTeamId = playerTeamId;
    }

    @JsonProperty("buyoutClauseLockedEndTime")
    public LocalDateTime getBuyoutClauseLockedEndTime() {
        return buyoutClauseLockedEndTime;
    }

    @JsonProperty("buyoutClauseLockedEndTime")
    public void setBuyoutClauseLockedEndTime(LocalDateTime buyoutClauseLockedEndTime) {
        this.buyoutClauseLockedEndTime = buyoutClauseLockedEndTime;
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
		fantasyPlayer.setPlayerId(this.playerMaster.getId());
		fantasyPlayer.setPlayerName(this.playerMaster.getNickname());
		fantasyPlayer.setLeagueId(leagueId);
		fantasyPlayer.setOperation("purchase");
		fantasyPlayer.setMoney(null);
		fantasyPlayer.setDate(null);
		return fantasyPlayer;
	}

}
