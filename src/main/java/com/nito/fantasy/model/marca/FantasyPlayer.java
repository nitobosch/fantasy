
package com.nito.fantasy.model.marca;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.nito.fantasy.model.dynamodb.FantasyPlayerDB;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "points", "weekPoints", "averagePoints", "images", "id", "team", "name", "lastSeasonPoints", "nickname",
		"slug", "birthDate", "birthplace", "positionId", "position", "height", "image30x30", "image250x250", "image96x96",
		"playerStats", "marketValue", "playerStatus" })
public class FantasyPlayer {

	@JsonProperty("points")
	private Integer points;

	@JsonProperty("weekPoints")
	private Integer weekPoints;

	@JsonProperty("averagePoints")
	private Double averagePoints;

	@JsonProperty("images")
	private Images images;

	@JsonProperty("id")
	private String id;

	@JsonProperty("team")
	private TeamPlayer team;

	@JsonProperty("name")
	private String name;

	@JsonProperty("lastSeasonPoints")
	private Integer lastSeasonPoints;

	@JsonProperty("nickname")
	private String nickname;

	@JsonProperty("slug")
	private String slug;

	@JsonProperty("birthDate")
	private String birthDate;

	@JsonProperty("birthplace")
	private String birthplace;

	@JsonProperty("positionId")
	private Integer positionId;

	@JsonProperty("position")
	private String position;

	@JsonProperty("height")
	private Double height;

	@JsonProperty("image30x30")
	private String image30x30;

	@JsonProperty("image250x250")
	private String image250x250;

	@JsonProperty("image96x96")
	private String image96x96;

	@JsonProperty("playerStats")
	private List<PlayerStat> playerStats = null;

	@JsonProperty("marketValue")
	private Integer marketValue;

	@JsonProperty("playerStatus")
	private String playerStatus;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("points")
	public Integer getPoints() {
		return points;
	}

	@JsonProperty("points")
	public void setPoints(Integer points) {
		this.points = points;
	}

	@JsonProperty("weekPoints")
	public Integer getWeekPoints() {
		return weekPoints;
	}

	@JsonProperty("weekPoints")
	public void setWeekPoints(Integer weekPoints) {
		this.weekPoints = weekPoints;
	}

	@JsonProperty("averagePoints")
	public Double getAveragePoints() {
		return averagePoints;
	}

	@JsonProperty("averagePoints")
	public void setAveragePoints(Double averagePoints) {
		this.averagePoints = averagePoints;
	}

	@JsonProperty("images")
	public Images getImages() {
		return images;
	}

	@JsonProperty("images")
	public void setImages(Images images) {
		this.images = images;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("team")
	public TeamPlayer getTeam() {
		return team;
	}

	@JsonProperty("team")
	public void setTeam(TeamPlayer team) {
		this.team = team;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("lastSeasonPoints")
	public Integer getLastSeasonPoints() {
		return lastSeasonPoints;
	}

	@JsonProperty("lastSeasonPoints")
	public void setLastSeasonPoints(Integer lastSeasonPoints) {
		this.lastSeasonPoints = lastSeasonPoints;
	}

	@JsonProperty("nickname")
	public String getNickname() {
		return nickname;
	}

	@JsonProperty("nickname")
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@JsonProperty("slug")
	public String getSlug() {
		return slug;
	}

	@JsonProperty("slug")
	public void setSlug(String slug) {
		this.slug = slug;
	}

	@JsonProperty("birthDate")
	public String getBirthDate() {
		return birthDate;
	}

	@JsonProperty("birthDate")
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@JsonProperty("birthplace")
	public String getBirthplace() {
		return birthplace;
	}

	@JsonProperty("birthplace")
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	@JsonProperty("positionId")
	public Integer getPositionId() {
		return positionId;
	}

	@JsonProperty("positionId")
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	@JsonProperty("position")
	public String getPosition() {
		return position;
	}

	@JsonProperty("position")
	public void setPosition(String position) {
		this.position = position;
	}

	@JsonProperty("height")
	public Double getHeight() {
		return height;
	}

	@JsonProperty("height")
	public void setHeight(Double height) {
		this.height = height;
	}

	@JsonProperty("image30x30")
	public String getImage30x30() {
		return image30x30;
	}

	@JsonProperty("image30x30")
	public void setImage30x30(String image30x30) {
		this.image30x30 = image30x30;
	}

	@JsonProperty("image250x250")
	public String getImage250x250() {
		return image250x250;
	}

	@JsonProperty("image250x250")
	public void setImage250x250(String image250x250) {
		this.image250x250 = image250x250;
	}

	@JsonProperty("image96x96")
	public String getImage96x96() {
		return image96x96;
	}

	@JsonProperty("image96x96")
	public void setImage96x96(String image96x96) {
		this.image96x96 = image96x96;
	}

	@JsonProperty("playerStats")
	public List<PlayerStat> getPlayerStats() {
		return playerStats;
	}

	@JsonProperty("playerStats")
	public void setPlayerStats(List<PlayerStat> playerStats) {
		this.playerStats = playerStats;
	}

	@JsonProperty("marketValue")
	public Integer getMarketValue() {
		return marketValue;
	}

	@JsonProperty("marketValue")
	public void setMarketValue(Integer marketValue) {
		this.marketValue = marketValue;
	}

	@JsonProperty("playerStatus")
	public String getPlayerStatus() {
		return playerStatus;
	}

	@JsonProperty("playerStatus")
	public void setPlayerStatus(String playerStatus) {
		this.playerStatus = playerStatus;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public FantasyPlayerDB convertToEntityDB() {
		FantasyPlayerDB fantasyPlayer = new FantasyPlayerDB();
		fantasyPlayer.setId(this.id);

		return fantasyPlayer;
	}

}
