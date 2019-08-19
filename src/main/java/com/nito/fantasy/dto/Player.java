package com.nito.fantasy.dto;

import java.time.LocalDateTime;

import com.nito.fantasy.model.dynamodb.FantasyPlayerHistoryDB;

public class Player {
	private String playerId;

	private String playerName;

	private String managerName;

	private String teamId;

	private Integer playerPoints;

	private Integer playerPointsAA;

	private Integer playerValue;

	private Integer playerNumBids;

	private String playerImage;

	private String playerTeamName;

	private String playerTeamImage;

	private String playerPositionName;

	private Integer playerPositionId;

	private Integer playerBuyoutClause;

	private LocalDateTime playerEndBuyoutClause;

	private Integer diffMarketValuefromBuyoutClause;

	private String upDownMarketValuefromBuyoutClause;

	private Integer playerMarketValueYesterday;

	private Integer diffMarketValuefromYesterday;

	private String upDownMarketValuefromYesterday;

	private LocalDateTime playerPurchaseDate;

	private Integer playerPurchaseAmount;

	private Integer diffMarketValuefromPurchaseAmount;

	private String upDownMarketValuefromPurchaseAmount;

	private Integer playerMarketValuePurchaseDate;

	private Integer diffMarketValuefromPurchaseDate;

	private String upDownMarketValuefromPurchaseDate;

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

	public String getUpDownMarketValuefromYesterday() {
		return upDownMarketValuefromYesterday;
	}

	public void setUpDownMarketValuefromYesterday(String upDownMarketValuefromYesterday) {
		this.upDownMarketValuefromYesterday = upDownMarketValuefromYesterday;
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

	public String getUpDownMarketValuefromPurchaseAmount() {
		return upDownMarketValuefromPurchaseAmount;
	}

	public void setUpDownMarketValuefromPurchaseAmount(String upDownMarketValuefromPurchaseAmount) {
		this.upDownMarketValuefromPurchaseAmount = upDownMarketValuefromPurchaseAmount;
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

	public String getUpDownMarketValuefromPurchaseDate() {
		return upDownMarketValuefromPurchaseDate;
	}

	public void setUpDownMarketValuefromPurchaseDate(String upDownMarketValuefromPurchaseDate) {
		this.upDownMarketValuefromPurchaseDate = upDownMarketValuefromPurchaseDate;
	}

	public void setUpDownBuyoutClause() {

		Integer diffValor = this.playerValue - this.playerBuyoutClause;
		setDiffMarketValuefromBuyoutClause(diffValor);
		if (diffValor > 0) {
			setUpDownMarketValuefromBuyoutClause("UP");
		} else if (diffValor < 0) {
			setUpDownMarketValuefromBuyoutClause("DOWN");
		} else {
			setUpDownMarketValuefromBuyoutClause("=");
		}
	}

	public void setUpDownYesterday(Integer valueAyer) {

		Integer diffValor = this.playerValue - valueAyer;
		setPlayerMarketValueYesterday(valueAyer);
		setDiffMarketValuefromYesterday(diffValor);
		if (diffValor > 0) {
			setUpDownMarketValuefromYesterday("UP");
		} else if (diffValor < 0) {
			setUpDownMarketValuefromYesterday("DOWN");
		} else {
			setUpDownMarketValuefromYesterday("=");
		}
	}

	public void setUpDownPurchaseDate(LocalDateTime purchaseDate, Integer purchaseAmount, Integer marketValue) {

		Integer diffValor = null;
		if (purchaseDate != null) {
			setPlayerPurchaseDate(purchaseDate);
			// valor compra
			setPlayerPurchaseAmount(purchaseAmount);
			diffValor = this.playerValue - purchaseAmount;
			setDiffMarketValuefromPurchaseAmount(diffValor);
			if (diffValor > 0) {
				setUpDownMarketValuefromPurchaseAmount("UP");
			} else if (diffValor < 0) {
				setUpDownMarketValuefromPurchaseAmount("DOWN");
			} else {
				setUpDownMarketValuefromPurchaseAmount("=");
			}
			// valor mercado
			setPlayerMarketValuePurchaseDate(marketValue);
			diffValor = this.playerValue - marketValue;
			setDiffMarketValuefromPurchaseDate(diffValor);
			if (diffValor > 0) {
				setUpDownMarketValuefromPurchaseDate("UP");
			} else if (diffValor < 0) {
				setUpDownMarketValuefromPurchaseDate("DOWN");
			} else {
				setUpDownMarketValuefromPurchaseDate("=");
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

	public String getUpDownMarketValuefromBuyoutClause() {
		return upDownMarketValuefromBuyoutClause;
	}

	public void setUpDownMarketValuefromBuyoutClause(String upDownMarketValuefromBuyoutClause) {
		this.upDownMarketValuefromBuyoutClause = upDownMarketValuefromBuyoutClause;
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

}
