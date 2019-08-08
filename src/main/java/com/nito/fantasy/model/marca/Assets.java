
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
    "billboard",
    "billboard_sponsor",
    "logo_list_item",
    "logo",
    "jersey",
    "jersey_full",
    "logo_white",
    "icon_app",
    "icon_off",
    "banner",
    "banner_url"
})
public class Assets {

    @JsonProperty("billboard")
    private String billboard;
    @JsonProperty("billboard_sponsor")
    private String billboardSponsor;
    @JsonProperty("logo_list_item")
    private String logoListItem;
    @JsonProperty("logo")
    private String logo;
    @JsonProperty("jersey")
    private String jersey;
    @JsonProperty("jersey_full")
    private String jerseyFull;
    @JsonProperty("logo_white")
    private String logoWhite;
    @JsonProperty("icon_app")
    private String iconApp;
    @JsonProperty("icon_off")
    private String iconOff;
    @JsonProperty("banner")
    private String banner;
    @JsonProperty("banner_url")
    private String bannerUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("billboard")
    public String getBillboard() {
        return billboard;
    }

    @JsonProperty("billboard")
    public void setBillboard(String billboard) {
        this.billboard = billboard;
    }

    @JsonProperty("billboard_sponsor")
    public String getBillboardSponsor() {
        return billboardSponsor;
    }

    @JsonProperty("billboard_sponsor")
    public void setBillboardSponsor(String billboardSponsor) {
        this.billboardSponsor = billboardSponsor;
    }

    @JsonProperty("logo_list_item")
    public String getLogoListItem() {
        return logoListItem;
    }

    @JsonProperty("logo_list_item")
    public void setLogoListItem(String logoListItem) {
        this.logoListItem = logoListItem;
    }

    @JsonProperty("logo")
    public String getLogo() {
        return logo;
    }

    @JsonProperty("logo")
    public void setLogo(String logo) {
        this.logo = logo;
    }

    @JsonProperty("jersey")
    public String getJersey() {
        return jersey;
    }

    @JsonProperty("jersey")
    public void setJersey(String jersey) {
        this.jersey = jersey;
    }

    @JsonProperty("jersey_full")
    public String getJerseyFull() {
        return jerseyFull;
    }

    @JsonProperty("jersey_full")
    public void setJerseyFull(String jerseyFull) {
        this.jerseyFull = jerseyFull;
    }

    @JsonProperty("logo_white")
    public String getLogoWhite() {
        return logoWhite;
    }

    @JsonProperty("logo_white")
    public void setLogoWhite(String logoWhite) {
        this.logoWhite = logoWhite;
    }

    @JsonProperty("icon_app")
    public String getIconApp() {
        return iconApp;
    }

    @JsonProperty("icon_app")
    public void setIconApp(String iconApp) {
        this.iconApp = iconApp;
    }

    @JsonProperty("icon_off")
    public String getIconOff() {
        return iconOff;
    }

    @JsonProperty("icon_off")
    public void setIconOff(String iconOff) {
        this.iconOff = iconOff;
    }

    @JsonProperty("banner")
    public String getBanner() {
        return banner;
    }

    @JsonProperty("banner")
    public void setBanner(String banner) {
        this.banner = banner;
    }

    @JsonProperty("banner_url")
    public String getBannerUrl() {
        return bannerUrl;
    }

    @JsonProperty("banner_url")
    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
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
