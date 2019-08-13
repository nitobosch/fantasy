package com.nito.fantasy.dto;

public class Ranking {
	private boolean state;
	private Integer position;
	private String managerName;
	private String teamId;
	private Integer teamPoints;
	private Integer teamValue;
	private String teamValueFormatted;
	private Integer teamMoney;
	private String teamMoneyFormatted;
	private Integer teamMoneyAprox;
	private String teamMoneyAproxFormatted;
	public Ranking() {
		super();
	}
	public String getTeamValueFormatted() {
		return teamValueFormatted;
	}
	public void setTeamValueFormatted(String teamValueFormatted) {
		this.teamValueFormatted = teamValueFormatted;
	}
	public String getTeamMoneyFormatted() {
		return teamMoneyFormatted;
	}
	public void setTeamMoneyFormatted(String teamMoneyFormatted) {
		this.teamMoneyFormatted = teamMoneyFormatted;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public Integer getTeamPoints() {
		return teamPoints;
	}
	public void setTeamPoints(Integer teamPoints) {
		this.teamPoints = teamPoints;
	}
	public Integer getTeamValue() {
		return teamValue;
	}
	public void setTeamValue(Integer teamValue) {
		this.teamValue = teamValue;
	}
	public Integer getTeamMoney() {
		return teamMoney;
	}
	public void setTeamMoney(Integer teamMoney) {
		this.teamMoney = teamMoney;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Integer getTeamMoneyAprox() {
		return teamMoneyAprox;
	}
	public void setTeamMoneyAprox(Integer teamMoneyAprox) {
		this.teamMoneyAprox = teamMoneyAprox;
	}
	public String getTeamMoneyAproxFormatted() {
		return teamMoneyAproxFormatted;
	}
	public void setTeamMoneyAproxFormatted(String teamMoneyAproxFormatted) {
		this.teamMoneyAproxFormatted = teamMoneyAproxFormatted;
	}
	

}
