
package com.nito.fantasy.model.marca;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.nito.fantasy.model.dynamodb.FantasyNewDB;
import com.nito.fantasy.model.dynamodb.FantasyPlayerDB;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "image30x30",
    "image96x96",
    "image250x250",
    "images",
    "positionId",
    "nickname",
    "lastSeasonPoints",
    "playerStatus",
    "marketValue",
    "team",
    "points",
    "averagePoints"
})
public class FantasyPlayer {

    @JsonProperty("id")
    private String id;
    @JsonProperty("image30x30")
    private String image30x30;
    @JsonProperty("image96x96")
    private String image96x96;
    @JsonProperty("image250x250")
    private String image250x250;
    @JsonProperty("images")
    private Images images;
    @JsonProperty("positionId")
    private Integer positionId;
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("lastSeasonPoints")
    private Integer lastSeasonPoints;
    @JsonProperty("playerStatus")
    private String playerStatus;
    @JsonProperty("marketValue")
    private Integer marketValue;
    @JsonProperty("team")
    private TeamPlayer team;
    @JsonProperty("points")
    private Integer points;
    @JsonProperty("averagePoints")
    private Integer averagePoints;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("image30x30")
    public String getImage30x30() {
        return image30x30;
    }

    @JsonProperty("image30x30")
    public void setImage30x30(String image30x30) {
        this.image30x30 = image30x30;
    }

    @JsonProperty("image96x96")
    public String getImage96x96() {
        return image96x96;
    }

    @JsonProperty("image96x96")
    public void setImage96x96(String image96x96) {
        this.image96x96 = image96x96;
    }

    @JsonProperty("image250x250")
    public String getImage250x250() {
        return image250x250;
    }

    @JsonProperty("image250x250")
    public void setImage250x250(String image250x250) {
        this.image250x250 = image250x250;
    }

    @JsonProperty("images")
    public Images getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(Images images) {
        this.images = images;
    }

    @JsonProperty("positionId")
    public Integer getPositionId() {
        return positionId;
    }

    @JsonProperty("positionId")
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    @JsonProperty("nickname")
    public String getNickname() {
        return nickname;
    }

    @JsonProperty("nickname")
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @JsonProperty("lastSeasonPoints")
    public Integer getLastSeasonPoints() {
        return lastSeasonPoints;
    }

    @JsonProperty("lastSeasonPoints")
    public void setLastSeasonPoints(Integer lastSeasonPoints) {
        this.lastSeasonPoints = lastSeasonPoints;
    }

    @JsonProperty("playerStatus")
    public String getPlayerStatus() {
        return playerStatus;
    }

    @JsonProperty("playerStatus")
    public void setPlayerStatus(String playerStatus) {
        this.playerStatus = playerStatus;
    }

    @JsonProperty("marketValue")
    public Integer getMarketValue() {
        return marketValue;
    }

    @JsonProperty("marketValue")
    public void setMarketValue(Integer marketValue) {
        this.marketValue = marketValue;
    }

    @JsonProperty("team")
    public TeamPlayer getTeam() {
        return team;
    }

    @JsonProperty("team")
    public void setTeam(TeamPlayer team) {
        this.team = team;
    }

    @JsonProperty("points")
    public Integer getPoints() {
        return points;
    }

    @JsonProperty("points")
    public void setPoints(Integer points) {
        this.points = points;
    }

    @JsonProperty("averagePoints")
    public Integer getAveragePoints() {
        return averagePoints;
    }

    @JsonProperty("averagePoints")
    public void setAveragePoints(Integer averagePoints) {
        this.averagePoints = averagePoints;
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
		fantasyPlayer.setPlayerName(this.nickname);
		fantasyPlayer.setPlayerPoints(this.points);
		fantasyPlayer.setPlayerPointsAA(this.lastSeasonPoints);
		fantasyPlayer.setPlayerPositionId(this.positionId);
		fantasyPlayer.setPlayerTeamName(this.team.getName());
		fantasyPlayer.setPlayerImage(this.images.getTransparent().get64x64());
		fantasyPlayer.setPlayerMarketValue(this.marketValue);
		fantasyPlayer.setPlayerTeamImage(this.team.getBadgeColor());
		
		return fantasyPlayer;
	}

}
