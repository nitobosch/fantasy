
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
    "id",
    "canBeDuplicated",
    "sponsorId",
    "dspId",
    "sponsor",
    "color",
    "textColor",
    "front",
    "frontUrl",
    "description",
    "assets"
})
public class Type {

    @JsonProperty("id")
    private String id;
    @JsonProperty("canBeDuplicated")
    private Boolean canBeDuplicated;
    @JsonProperty("sponsorId")
    private Integer sponsorId;
    @JsonProperty("dspId")
    private String dspId;
    @JsonProperty("sponsor")
    private Sponsor sponsor;
    @JsonProperty("color")
    private String color;
    @JsonProperty("textColor")
    private String textColor;
    @JsonProperty("front")
    private String front;
    @JsonProperty("frontUrl")
    private String frontUrl;
    @JsonProperty("description")
    private String description;
    @JsonProperty("assets")
    private Assets assets;
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

    @JsonProperty("canBeDuplicated")
    public Boolean getCanBeDuplicated() {
        return canBeDuplicated;
    }

    @JsonProperty("canBeDuplicated")
    public void setCanBeDuplicated(Boolean canBeDuplicated) {
        this.canBeDuplicated = canBeDuplicated;
    }

    @JsonProperty("sponsorId")
    public Integer getSponsorId() {
        return sponsorId;
    }

    @JsonProperty("sponsorId")
    public void setSponsorId(Integer sponsorId) {
        this.sponsorId = sponsorId;
    }

    @JsonProperty("dspId")
    public String getDspId() {
        return dspId;
    }

    @JsonProperty("dspId")
    public void setDspId(String dspId) {
        this.dspId = dspId;
    }

    @JsonProperty("sponsor")
    public Sponsor getSponsor() {
        return sponsor;
    }

    @JsonProperty("sponsor")
    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    @JsonProperty("textColor")
    public String getTextColor() {
        return textColor;
    }

    @JsonProperty("textColor")
    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    @JsonProperty("front")
    public String getFront() {
        return front;
    }

    @JsonProperty("front")
    public void setFront(String front) {
        this.front = front;
    }

    @JsonProperty("frontUrl")
    public String getFrontUrl() {
        return frontUrl;
    }

    @JsonProperty("frontUrl")
    public void setFrontUrl(String frontUrl) {
        this.frontUrl = frontUrl;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("assets")
    public Assets getAssets() {
        return assets;
    }

    @JsonProperty("assets")
    public void setAssets(Assets assets) {
        this.assets = assets;
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
