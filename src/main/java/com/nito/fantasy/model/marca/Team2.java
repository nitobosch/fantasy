
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
    "badgeColor",
    "badgeGray",
    "badgeWhite",
    "name",
    "id",
    "slug"
})
public class Team2 {

    @JsonProperty("badgeColor")
    private String badgeColor;
    @JsonProperty("badgeGray")
    private String badgeGray;
    @JsonProperty("badgeWhite")
    private String badgeWhite;
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;
    @JsonProperty("slug")
    private String slug;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("badgeColor")
    public String getBadgeColor() {
        return badgeColor;
    }

    @JsonProperty("badgeColor")
    public void setBadgeColor(String badgeColor) {
        this.badgeColor = badgeColor;
    }

    @JsonProperty("badgeGray")
    public String getBadgeGray() {
        return badgeGray;
    }

    @JsonProperty("badgeGray")
    public void setBadgeGray(String badgeGray) {
        this.badgeGray = badgeGray;
    }

    @JsonProperty("badgeWhite")
    public String getBadgeWhite() {
        return badgeWhite;
    }

    @JsonProperty("badgeWhite")
    public void setBadgeWhite(String badgeWhite) {
        this.badgeWhite = badgeWhite;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
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
