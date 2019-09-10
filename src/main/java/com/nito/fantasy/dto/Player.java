package com.nito.fantasy.dto;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;

import com.nito.fantasy.model.dynamodb.FantasyPlayerHistoryDB;

public class Player {
	private static final Logger logger = Logger.getLogger(Player.class);

	private String playerId;

	private String playerTeamId;

	private String playerName;

	private String managerName;

	private String teamId;

	private Integer playerPoints;

	private Double playerAveragePoints;

	private Double playerAveragePointsGame;

	private Double playerAveragePointsGame2;

	private Double playerAveragePointsMinutes;

	private Double playerAveragePointsMinutesGame;

	private Double playerAverageMinutesGame;

	private Integer playerPointsAA;

	private Integer playerValue;

	private Integer playerGamesPlayed;

	private Integer playerGamesPlayed2;

	private Integer playerMinutesPlayed;

	private Integer playerNumBids;

	private String playerImage;

	private String playerTeamName;

	private String playerTeamImage;

	private String playerPositionName;

	private Integer playerPositionId;

	private Integer playerBuyoutClause;

	private LocalDateTime playerEndBuyoutClause;

	private Integer diffMarketValuefromBuyoutClause;

	private Integer playerMarketValueYesterday;

	private Integer diffMarketValuefromYesterday;

	private Integer playerMarketValueYesterday1;

	private Integer diffMarketValuefromYesterday1;

	private Integer playerMarketValueYesterday2;

	private Integer diffMarketValuefromYesterday2;

	private LocalDateTime playerPurchaseDate;

	private Integer playerPurchaseAmount;

	private Integer diffMarketValuefromPurchaseAmount;

	private Integer playerMarketValuePurchaseDate;

	private Integer diffMarketValuefromPurchaseDate;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getDiffMarketValuefromBuyoutClause() {
		return diffMarketValuefromBuyoutClause;
	}

	public void setDiffMarketValuefromBuyoutClause(Integer diffMarketValuefromBuyoutClause) {
		this.diffMarketValuefromBuyoutClause = diffMarketValuefromBuyoutClause;
	}

	public Integer getPlayerMarketValueYesterday() {
		return playerMarketValueYesterday;
	}

	public void setPlayerMarketValueYesterday(Integer playerMarketValueYesterday) {
		this.playerMarketValueYesterday = playerMarketValueYesterday;
	}

	public Integer getDiffMarketValuefromYesterday() {
		return diffMarketValuefromYesterday;
	}

	public void setDiffMarketValuefromYesterday(Integer diffMarketValuefromYesterday) {
		this.diffMarketValuefromYesterday = diffMarketValuefromYesterday;
	}

	public LocalDateTime getPlayerEndBuyoutClause() {
		return playerEndBuyoutClause;
	}

	public void setPlayerEndBuyoutClause(LocalDateTime playerEndBuyoutClause) {
		this.playerEndBuyoutClause = playerEndBuyoutClause;
	}

	public Integer getPlayerBuyoutClause() {
		return playerBuyoutClause;
	}

	public void setPlayerBuyoutClause(Integer playerBuyoutClause) {
		this.playerBuyoutClause = playerBuyoutClause;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Integer getPlayerPoints() {
		return playerPoints;
	}

	public void setPlayerPoints(Integer playerPoints) {
		this.playerPoints = playerPoints;
	}

	public Integer getPlayerValue() {
		return playerValue;
	}

	public void setPlayerValue(Integer playerValue) {
		this.playerValue = playerValue;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public Integer getPlayerPointsAA() {
		return playerPointsAA;
	}

	public void setPlayerPointsAA(Integer playerPointsAA) {
		this.playerPointsAA = playerPointsAA;
	}

	public LocalDateTime getPlayerPurchaseDate() {
		return playerPurchaseDate;
	}

	public void setPlayerPurchaseDate(LocalDateTime playerPurchaseDate) {
		this.playerPurchaseDate = playerPurchaseDate;
	}

	public Integer getPlayerPurchaseAmount() {
		return playerPurchaseAmount;
	}

	public void setPlayerPurchaseAmount(Integer playerPurchaseAmount) {
		this.playerPurchaseAmount = playerPurchaseAmount;
	}

	public Integer getDiffMarketValuefromPurchaseAmount() {
		return diffMarketValuefromPurchaseAmount;
	}

	public void setDiffMarketValuefromPurchaseAmount(Integer diffMarketValuefromPurchaseAmount) {
		this.diffMarketValuefromPurchaseAmount = diffMarketValuefromPurchaseAmount;
	}

	public Integer getPlayerMarketValuePurchaseDate() {
		return playerMarketValuePurchaseDate;
	}

	public void setPlayerMarketValuePurchaseDate(Integer playerMarketValuePurchaseDate) {
		this.playerMarketValuePurchaseDate = playerMarketValuePurchaseDate;
	}

	public Integer getDiffMarketValuefromPurchaseDate() {
		return diffMarketValuefromPurchaseDate;
	}

	public void setDiffMarketValuefromPurchaseDate(Integer diffMarketValuefromPurchaseDate) {
		this.diffMarketValuefromPurchaseDate = diffMarketValuefromPurchaseDate;
	}

	public void setUpDownBuyoutClause() {

		Integer diffValor = this.playerValue - this.playerBuyoutClause;
		setDiffMarketValuefromBuyoutClause(diffValor);
	}

	public void setUpDownYesterday(Integer valueAyer, Integer valueAyer1, Integer valueAyer2) {

		Integer diffValor = null;
		if (valueAyer != null) {
			diffValor = this.playerValue - valueAyer;
			setPlayerMarketValueYesterday(valueAyer);
			setDiffMarketValuefromYesterday(diffValor);

			if (valueAyer1 != null) {
				diffValor = valueAyer - valueAyer1;
				setPlayerMarketValueYesterday1(valueAyer1);
				setDiffMarketValuefromYesterday1(diffValor);

				if (valueAyer2 != null) {
					diffValor = valueAyer1 - valueAyer2;
					setPlayerMarketValueYesterday2(valueAyer2);
					setDiffMarketValuefromYesterday2(diffValor);
				}
			}
		}
	}

	public void setUpDownPurchaseDate(LocalDateTime purchaseDate, Integer purchaseAmount, Integer marketValue) {

		Integer diffValor = null;
		if (purchaseDate != null) {
			setPlayerPurchaseDate(purchaseDate);
			// valor compra
			if (purchaseAmount != null) {
				setPlayerPurchaseAmount(purchaseAmount);
				diffValor = this.playerValue - purchaseAmount;
				setDiffMarketValuefromPurchaseAmount(diffValor);
			}
			// valor mercado
			if (marketValue != null) {
				setPlayerMarketValuePurchaseDate(marketValue);
				diffValor = this.playerValue - marketValue;
				setDiffMarketValuefromPurchaseDate(diffValor);
			}
		}
	}

	public FantasyPlayerHistoryDB convertToEntityDB() {
		FantasyPlayerHistoryDB fantasyPlayer = new FantasyPlayerHistoryDB();
		fantasyPlayer.setPlayerId(this.playerId);
		fantasyPlayer.setPlayerName(this.playerName);
		return fantasyPlayer;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public Integer getPlayerNumBids() {
		return playerNumBids;
	}

	public void setPlayerNumBids(Integer playerNumBids) {
		this.playerNumBids = playerNumBids;
	}

	public String getPlayerImage() {
		return playerImage;
	}

	public void setPlayerImage(String playerImage) {
		this.playerImage = playerImage;
	}

	public String getPlayerTeamName() {
		return playerTeamName;
	}

	public void setPlayerTeamName(String playerTeamName) {
		this.playerTeamName = playerTeamName;
	}

	public String getPlayerTeamImage() {
		return playerTeamImage;
	}

	public void setPlayerTeamImage(String playerTeamImage) {
		this.playerTeamImage = playerTeamImage;
	}

	public Integer getPlayerPositionId() {
		return playerPositionId;
	}

	public void setPlayerPosition(Integer playerPositionId) {
		this.playerPositionId = playerPositionId;
		this.playerPositionName = PlayerPosition.getPlayerPosition(playerPositionId).getValue();
	}

	public String getPlayerPositionName() {
		return playerPositionName;
	}

	public void setPlayerPositionName(String playerPositionName) {
		this.playerPositionName = playerPositionName;
	}

	public Double getPlayerAveragePoints() {
		return playerAveragePoints;
	}

	public void setPlayerAveragePoints(Double playerAveragePoints) {
		this.playerAveragePoints = playerAveragePoints;
	}

	public Integer getPlayerMarketValueYesterday2() {
		return playerMarketValueYesterday2;
	}

	public void setPlayerMarketValueYesterday2(Integer playerMarketValueYesterday2) {
		this.playerMarketValueYesterday2 = playerMarketValueYesterday2;
	}

	public Integer getDiffMarketValuefromYesterday2() {
		return diffMarketValuefromYesterday2;
	}

	public void setDiffMarketValuefromYesterday2(Integer diffMarketValuefromYesterday2) {
		this.diffMarketValuefromYesterday2 = diffMarketValuefromYesterday2;
	}

	public Integer getPlayerGamesPlayed() {
		return playerGamesPlayed;
	}

	public void setPlayerGamesPlayed(Integer playerGamesPlayed) {
		this.playerGamesPlayed = playerGamesPlayed;
	}

	public Integer getPlayerMinutesPlayed() {
		return playerMinutesPlayed;
	}

	public void setPlayerMinutesPlayed(Integer playerMinutesPlayed) {
		this.playerMinutesPlayed = playerMinutesPlayed;
	}

	public void setPlayerAveragePointsGame() {
		Double aux = null;
		if (this.playerGamesPlayed != null && this.playerGamesPlayed > 0) {
			aux = (double) this.playerPoints / (double) this.playerGamesPlayed;
		}
		this.playerAveragePointsGame = aux;
	}

	public void setPlayerAveragePointsGame(Double playerAveragePointsGame) {
		this.playerAveragePointsGame = playerAveragePointsGame;
	}

	public void setPlayerAveragePointsMinutes() {
		Double aux = null;
		if (this.playerMinutesPlayed != null && this.playerMinutesPlayed > 0) {
			aux = (double) this.playerPoints / (double) this.playerMinutesPlayed;
		}
		this.playerAveragePointsMinutes = aux;
	}

	public void setPlayerAveragePointsMinutes(Double playerAveragePointsMinutes) {
		this.playerAveragePointsMinutes = playerAveragePointsMinutes;
	}

	public void setPlayerAveragePointsMinutesGame() {
		Double aux = null;
		if (this.playerAveragePointsMinutes != null) {
			aux = this.playerAveragePointsMinutes * 90;
		}
		this.playerAveragePointsMinutesGame = aux;
	}

	public void setPlayerAveragePointsMinutesGame(Double playerAveragePointsMinutesGame) {
		this.playerAveragePointsMinutesGame = playerAveragePointsMinutesGame;
	}

	public Double getPlayerAveragePointsGame() {
		return playerAveragePointsGame;
	}

	public Double getPlayerAveragePointsMinutes() {
		return playerAveragePointsMinutes;
	}

	public Double getPlayerAveragePointsMinutesGame() {
		return playerAveragePointsMinutesGame;
	}

	public void setPlayerPositionId(Integer playerPositionId) {
		this.playerPositionId = playerPositionId;
	}

	public Integer getPlayerMarketValueYesterday1() {
		return playerMarketValueYesterday1;
	}

	public void setPlayerMarketValueYesterday1(Integer playerMarketValueYesterday1) {
		this.playerMarketValueYesterday1 = playerMarketValueYesterday1;
	}

	public Integer getDiffMarketValuefromYesterday1() {
		return diffMarketValuefromYesterday1;
	}

	public void setDiffMarketValuefromYesterday1(Integer diffMarketValuefromYesterday1) {
		this.diffMarketValuefromYesterday1 = diffMarketValuefromYesterday1;
	}

	public Integer getPlayerGamesPlayed2() {
		return playerGamesPlayed2;
	}

	public void setPlayerGamesPlayed2(Integer playerGamesPlayed2) {
		this.playerGamesPlayed2 = playerGamesPlayed2;
	}

	public Double getPlayerAveragePointsGame2() {
		return playerAveragePointsGame2;
	}

	public void setPlayerAveragePointsGame2(Double playerAveragePointsGame2) {
		this.playerAveragePointsGame2 = playerAveragePointsGame2;
	}

	public void setPlayerAveragePointsGame2() {
		Double aux = null;
		if (this.playerGamesPlayed2 != null && this.playerGamesPlayed2 > 0) {
			aux = (double) this.playerPoints / (double) this.playerGamesPlayed2;
		}
		this.playerAveragePointsGame2 = aux;
	}

	public Double getPlayerAverageMinutesGame() {
		return playerAverageMinutesGame;
	}

	public void setPlayerAverageMinutesGame(Double playerAverageMinutesGame) {
		this.playerAverageMinutesGame = playerAverageMinutesGame;
	}

	public void setPlayerAverageMinutesGame() {
		Double aux = null;
		if (this.playerMinutesPlayed != null && this.playerGamesPlayed > 0) {
			aux = (double) this.playerMinutesPlayed / (double) this.playerGamesPlayed;
		}
		this.playerAverageMinutesGame = aux;
	}

	public String getPlayerTeamId() {
		return playerTeamId;
	}

	public void setPlayerTeamId(String playerTeamId) {
		this.playerTeamId = playerTeamId;
	}

}
