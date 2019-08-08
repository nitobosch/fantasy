
package com.nito.fantasy.model.marca;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "discr",
    "playerMaster",
    "id",
    "salePrice",
    "expirationDate",
    "status",
    "leagueType",
    "leagueId",
    "numberOfBids"
})
public class FantasyMarket {

    @JsonProperty("discr")
    private String discr;
    @JsonProperty("playerMaster")
    private PlayerMaster playerMaster;
    @JsonProperty("id")
    private String id;
    @JsonProperty("salePrice")
    private Integer salePrice;
    @JsonProperty("expirationDate")
    private String expirationDate;
    @JsonProperty("status")
    private String status;
    @JsonProperty("leagueType")
    private String leagueType;
    @JsonProperty("leagueId")
    private Integer leagueId;
    @JsonProperty("numberOfBids")
    private Integer numberOfBids;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("discr")
    public String getDiscr() {
        return discr;
    }

    @JsonProperty("discr")
    public void setDiscr(String discr) {
        this.discr = discr;
    }

    @JsonProperty("playerMaster")
    public PlayerMaster getPlayerMaster() {
        return playerMaster;
    }

    @JsonProperty("playerMaster")
    public void setPlayerMaster(PlayerMaster playerMaster) {
        this.playerMaster = playerMaster;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("salePrice")
    public Integer getSalePrice() {
        return salePrice;
    }

    @JsonProperty("salePrice")
    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    @JsonProperty("expirationDate")
    public String getExpirationDate() {
        return expirationDate;
    }

    @JsonProperty("expirationDate")
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("leagueType")
    public String getLeagueType() {
        return leagueType;
    }

    @JsonProperty("leagueType")
    public void setLeagueType(String leagueType) {
        this.leagueType = leagueType;
    }

    @JsonProperty("leagueId")
    public Integer getLeagueId() {
        return leagueId;
    }

    @JsonProperty("leagueId")
    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    @JsonProperty("numberOfBids")
    public Integer getNumberOfBids() {
        return numberOfBids;
    }

    @JsonProperty("numberOfBids")
    public void setNumberOfBids(Integer numberOfBids) {
        this.numberOfBids = numberOfBids;
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
