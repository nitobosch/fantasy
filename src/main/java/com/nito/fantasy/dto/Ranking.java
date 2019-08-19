package com.nito.fantasy.dto;

public class Ranking {
	private boolean state;

	private Integer position;

	private String managerName;

	private String teamId;

	private Integer teamPoints;

	private Integer teamValue;

	private Integer teamMoney;

	private Integer teamMoneyAprox;

	private Integer teamMoneyAvailable;

	public Ranking() {
		super();
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

	public Integer getTeamMoneyAvailable() {
		return teamMoneyAvailable;
	}

	public void setTeamMoneyAvailable(Integer teamMoneyAvailable) {
		this.teamMoneyAvailable = teamMoneyAvailable;
	}

	public void setTeamMoneyAvailable() {
		this.teamMoneyAvailable = (int) Math.round(((this.teamValue * new Double(0.2)) + this.teamMoneyAprox));

	}

}
