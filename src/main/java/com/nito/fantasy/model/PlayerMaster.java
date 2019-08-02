
package com.nito.fantasy.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "points",
    "lastStats",
    "averagePoints",
    "images",
    "id",
    "team",
    "name",
    "lastSeasonPoints",
    "nickname",
    "slug",
    "birthDate",
    "birthplace",
    "positionId",
    "height",
    "image30x30",
    "image250x250",
    "image96x96",
    "marketValue",
    "playerStatus"
})
public class PlayerMaster {

    @JsonProperty("points")
    private Integer points;
    @JsonProperty("lastStats")
    private List<Object> lastStats = null;
    @JsonProperty("averagePoints")
    private Integer averagePoints;
    @JsonProperty("images")
    private Images images;
    @JsonProperty("id")
    private String id;
    @JsonProperty("team")
    private Team2 team;
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
    @JsonProperty("height")
    private Double height;
    @JsonProperty("image30x30")
    private String image30x30;
    @JsonProperty("image250x250")
    private String image250x250;
    @JsonProperty("image96x96")
    private String image96x96;
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

    @JsonProperty("lastStats")
    public List<Object> getLastStats() {
        return lastStats;
    }

    @JsonProperty("lastStats")
    public void setLastStats(List<Object> lastStats) {
        this.lastStats = lastStats;
    }

    @JsonProperty("averagePoints")
    public Integer getAveragePoints() {
        return averagePoints;
    }

    @JsonProperty("averagePoints")
    public void setAveragePoints(Integer averagePoints) {
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
    public Team2 getTeam() {
        return team;
    }

    @JsonProperty("team")
    public void setTeam(Team2 team) {
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

}
