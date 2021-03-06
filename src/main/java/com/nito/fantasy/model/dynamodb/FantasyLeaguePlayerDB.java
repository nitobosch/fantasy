package com.nito.fantasy.model.dynamodb;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.nito.fantasy.dto.Player;
import com.nito.fantasy.util.Formatter;
import com.nito.fantasy.util.LocalDateTimeConverter;

@DynamoDBTable(tableName = "FantasyLeaguePlayer")
public class FantasyLeaguePlayerDB {
	private static final Logger logger = Logger.getLogger(FantasyLeaguePlayerDB.class);

	private String id;

	private String leagueId;

	private String playerId;

	private String managerName;

	private String teamId;

	private Integer playerBuyoutClause;

	private LocalDateTime playerEndBuyoutClause;

	private LocalDateTime playerPurchaseDate;

	private Integer playerPurchaseAmount;

	private Integer playerMarketValuePurchaseDate;

	public FantasyLeaguePlayerDB() {
	}

	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBAttribute
	public String getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}

	@DynamoDBAttribute
	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	@DynamoDBAttribute
	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@DynamoDBAttribute
	public Integer getPlayerBuyoutClause() {
		return playerBuyoutClause;
	}

	public void setPlayerBuyoutClause(Integer playerBuyoutClause) {
		this.playerBuyoutClause = playerBuyoutClause;
	}

	@DynamoDBAttribute
	@DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
	public LocalDateTime getPlayerEndBuyoutClause() {
		return playerEndBuyoutClause;
	}

	public void setPlayerEndBuyoutClause(LocalDateTime playerEndBuyoutClause) {
		this.playerEndBuyoutClause = playerEndBuyoutClause;
	}

	@DynamoDBAttribute
	@DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
	public LocalDateTime getPlayerPurchaseDate() {
		return playerPurchaseDate;
	}

	public void setPlayerPurchaseDate(LocalDateTime playerPurchaseDate) {
		this.playerPurchaseDate = playerPurchaseDate;
	}

	@DynamoDBAttribute
	public Integer getPlayerPurchaseAmount() {
		return playerPurchaseAmount;
	}

	public void setPlayerPurchaseAmount(Integer playerPurchaseAmount) {
		this.playerPurchaseAmount = playerPurchaseAmount;
	}

	@DynamoDBAttribute
	public Integer getPlayerMarketValuePurchaseDate() {
		return playerMarketValuePurchaseDate;
	}

	public void setPlayerMarketValuePurchaseDate(Integer playerMarketValuePurchaseDate) {
		this.playerMarketValuePurchaseDate = playerMarketValuePurchaseDate;
	}

	public Player convertToDto() {
		Player newPlayer = new Player();
		newPlayer.setPlayerId(this.playerId);
		newPlayer.setManagerName(Formatter.parseNull(this.managerName));
		newPlayer.setTeamId(this.teamId);
		newPlayer.setPlayerBuyoutClause(this.playerBuyoutClause);
		newPlayer.setPlayerEndBuyoutClause(this.playerEndBuyoutClause);
		newPlayer.setUpDownBuyoutClause();
		newPlayer.setUpDownPurchaseDate(this.playerPurchaseDate, this.playerPurchaseAmount, this.playerMarketValuePurchaseDate);
		return newPlayer;
	}

	@DynamoDBAttribute
	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
}
