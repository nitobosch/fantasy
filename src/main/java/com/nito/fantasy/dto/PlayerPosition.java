package com.nito.fantasy.dto;

public enum PlayerPosition {
    POR("POR", "Portero", 1, "por"),
    DEF("DEF", "Defensa", 2, "def"),
    CEN("CEN", "Centrocampista", 3, "cen"),
    DEL("DEL", "Delantero", 4, "del");

    private final String value;
    private final String name;
    private final int id;
    private final String css;

    PlayerPosition(String value, String name, int id, String css) {
        this.value = value;
        this.name = name;
        this.id = id;
        this.css = css;
    }

	public String getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public String getCss() {
		return css;
	}

	public static PlayerPosition getPlayerPosition(String position) {
		switch (position) {
			case "Portero":
				return PlayerPosition.POR;
			case "Defensa":
				return PlayerPosition.DEF;
			case "Centrocampista":
				return PlayerPosition.CEN;
			case "Delantero":
				return PlayerPosition.DEL;
			default:
				return null;
		}
	}

	public static PlayerPosition getPlayerPosition(Integer positionId) {
		switch (positionId) {
			case 1:
				return PlayerPosition.POR;
			case 2:
				return PlayerPosition.DEF;
			case 3:
				return PlayerPosition.CEN;
			case 4:
				return PlayerPosition.DEL;
			default:
				return null;
		}
	}
}