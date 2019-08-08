package com.nito.fantasy.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.nito.fantasy.model.dynamodb.FantasyPlayerHistoryDB;
import com.nito.fantasy.util.Formatter;

public class Player {
	private String playerId;
	private String playerName;
	private String managerName;
	private String teamId;
	private Integer playerPoints;
	private Integer playerPointsAA;
	private Integer playerValue;
	private String playerValueFormatted;
	private Integer playerBuyoutClause;
	private String playerBuyoutClauseFormatted;
	private LocalDateTime playerEndBuyoutClause;
	private String playerEndBuyoutClauseFormatted;
	private Integer diffMarketValue;
	private String diffMarketValueFormatted;
	private String upDownMarketValue;
	
	private LocalDateTime playerPurchaseDate;
	private String playerPurchaseDateFormatted;
	private Integer playerPurchaseAmount;
	private String playerPurchaseAmountFormatted;
	private Integer diffMarketValuefromPurchaseAmount;
	private String diffMarketValuefromPurchaseAmountFormatted;
	private String upDownMarketValuefromPurchaseAmount;
	
	private Integer playerMarketValuePurchaseDate;
	private String playerMarketValuePurchaseDateFormatted;
	private Integer diffMarketValuefromPurchaseDate;
	private String diffMarketValuefromPurchaseDateFormatted;
	private String upDownMarketValuefromPurchaseDate;
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getDiffMarketValue() {
		return diffMarketValue;
	}
	public void setDiffMarketValue(Integer diffMarketValue) {
		this.diffMarketValue = diffMarketValue;
	}
	public String getDiffMarketValueFormatted() {
		return diffMarketValueFormatted;
	}
	public void setDiffMarketValueFormatted(String diffMarketValueFormatted) {
		this.diffMarketValueFormatted = diffMarketValueFormatted;
	}
	public LocalDateTime getPlayerEndBuyoutClause() {
		return playerEndBuyoutClause;
	}
	public void setPlayerEndBuyoutClause(LocalDateTime playerEndBuyoutClause) {
		this.playerEndBuyoutClause = playerEndBuyoutClause;
	}
	public String getPlayerEndBuyoutClauseFormatted() {
		return playerEndBuyoutClauseFormatted;
	}
	public void setPlayerEndBuyoutClauseFormatted(String playerEndBuyoutClauseFormatted) {
		this.playerEndBuyoutClauseFormatted = playerEndBuyoutClauseFormatted;
	}
	public Integer getPlayerBuyoutClause() {
		return playerBuyoutClause;
	}
	public void setPlayerBuyoutClause(Integer playerBuyoutClause) {
		this.playerBuyoutClause = playerBuyoutClause;
	}
	public String getPlayerBuyoutClauseFormatted() {
		return playerBuyoutClauseFormatted;
	}
	public void setPlayerBuyoutClauseFormatted(String playerBuyoutClauseFormatted) {
		this.playerBuyoutClauseFormatted = playerBuyoutClauseFormatted;
	}
	public String getPlayerValueFormatted() {
		return playerValueFormatted;
	}
	public void setPlayerValueFormatted(String playerValueFormatted) {
		this.playerValueFormatted = playerValueFormatted;
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
	public String getUpDownMarketValue() {
		return upDownMarketValue;
	}
	public void setUpDownMarketValue(String upDownMarketValue) {
		this.upDownMarketValue = upDownMarketValue;
	}
	public LocalDateTime getPlayerPurchaseDate() {
		return playerPurchaseDate;
	}
	public void setPlayerPurchaseDate(LocalDateTime playerPurchaseDate) {
		this.playerPurchaseDate = playerPurchaseDate;
	}
	public String getPlayerPurchaseDateFormatted() {
		return playerPurchaseDateFormatted;
	}
	public void setPlayerPurchaseDateFormatted(String playerPurchaseDateFormatted) {
		this.playerPurchaseDateFormatted = playerPurchaseDateFormatted;
	}
	public Integer getPlayerPurchaseAmount() {
		return playerPurchaseAmount;
	}
	public void setPlayerPurchaseAmount(Integer playerPurchaseAmount) {
		this.playerPurchaseAmount = playerPurchaseAmount;
	}
	public String getPlayerPurchaseAmountFormatted() {
		return playerPurchaseAmountFormatted;
	}
	public void setPlayerPurchaseAmountFormatted(String playerPurchaseAmountFormatted) {
		this.playerPurchaseAmountFormatted = playerPurchaseAmountFormatted;
	}
	public Integer getDiffMarketValuefromPurchaseAmount() {
		return diffMarketValuefromPurchaseAmount;
	}
	public void setDiffMarketValuefromPurchaseAmount(Integer diffMarketValuefromPurchaseAmount) {
		this.diffMarketValuefromPurchaseAmount = diffMarketValuefromPurchaseAmount;
	}
	public String getDiffMarketValuefromPurchaseAmountFormatted() {
		return diffMarketValuefromPurchaseAmountFormatted;
	}
	public void setDiffMarketValuefromPurchaseAmountFormatted(String diffMarketValuefromPurchaseAmountFormatted) {
		this.diffMarketValuefromPurchaseAmountFormatted = diffMarketValuefromPurchaseAmountFormatted;
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
	public String getPlayerMarketValuePurchaseDateFormatted() {
		return playerMarketValuePurchaseDateFormatted;
	}
	public void setPlayerMarketValuePurchaseDateFormatted(String playerMarketValuePurchaseDateFormatted) {
		this.playerMarketValuePurchaseDateFormatted = playerMarketValuePurchaseDateFormatted;
	}
	public Integer getDiffMarketValuefromPurchaseDate() {
		return diffMarketValuefromPurchaseDate;
	}
	public void setDiffMarketValuefromPurchaseDate(Integer diffMarketValuefromPurchaseDate) {
		this.diffMarketValuefromPurchaseDate = diffMarketValuefromPurchaseDate;
	}
	public String getDiffMarketValuefromPurchaseDateFormatted() {
		return diffMarketValuefromPurchaseDateFormatted;
	}
	public void setDiffMarketValuefromPurchaseDateFormatted(String diffMarketValuefromPurchaseDateFormatted) {
		this.diffMarketValuefromPurchaseDateFormatted = diffMarketValuefromPurchaseDateFormatted;
	}
	public String getUpDownMarketValuefromPurchaseDate() {
		return upDownMarketValuefromPurchaseDate;
	}
	public void setUpDownMarketValuefromPurchaseDate(String upDownMarketValuefromPurchaseDate) {
		this.upDownMarketValuefromPurchaseDate = upDownMarketValuefromPurchaseDate;
	}
	public void setUpDownYesterday(Integer valueAyer) {

		Integer diffValor = this.playerValue - valueAyer;
		setDiffMarketValue(diffValor);
		setDiffMarketValueFormatted(Formatter.formatNumber(diffValor));
		if(diffValor > 0) {
    		setUpDownMarketValue("UP");
		}else if(diffValor < 0) {
    		setUpDownMarketValue("DOWN");
		}else {
    		setUpDownMarketValue("=");
		}
	}
	public void setUpDownPurchaseDate(LocalDateTime purchaseDate, Integer purchaseAmount, Integer marketValue) {

		Integer diffValor = null;
		if(purchaseDate != null) {
			setPlayerPurchaseDate(purchaseDate);
			setPlayerPurchaseDateFormatted(Formatter.formatDate(purchaseDate));
			// valor compra
			setPlayerPurchaseAmount(purchaseAmount);
			setPlayerPurchaseAmountFormatted(Formatter.formatNumber(purchaseAmount));
			diffValor = this.playerValue - purchaseAmount;
			setDiffMarketValuefromPurchaseAmount(diffValor);
			setDiffMarketValuefromPurchaseAmountFormatted(Formatter.formatNumber(diffValor));
			if(diffValor > 0) {
	    		setUpDownMarketValuefromPurchaseAmount("UP");
			}else if(diffValor < 0) {
	    		setUpDownMarketValuefromPurchaseAmount("DOWN");
			}else {
	    		setUpDownMarketValuefromPurchaseAmount("=");
			}
			// valor mercado
			setPlayerMarketValuePurchaseDate(marketValue);
			setPlayerMarketValuePurchaseDateFormatted(Formatter.formatNumber(marketValue));
			diffValor = this.playerValue - marketValue;
			setDiffMarketValuefromPurchaseDate(diffValor);
			setDiffMarketValuefromPurchaseDateFormatted(Formatter.formatNumber(diffValor));
			if(diffValor > 0) {
	    		setUpDownMarketValuefromPurchaseDate("UP");
			}else if(diffValor < 0) {
	    		setUpDownMarketValuefromPurchaseDate("DOWN");
			}else {
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
	
}
