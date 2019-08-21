
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
    "expirationDate",
    "numberOfOffers",
    "offer",
    "directOffer"
})
public class PlayerMarket {

    @JsonProperty("id")
    private String id;
    @JsonProperty("expirationDate")
    private String expirationDate;
    @JsonProperty("numberOfOffers")
    private Integer numberOfOffers;
    @JsonProperty("offer")
    private Offer offer;
    @JsonProperty("directOffer")
    private Boolean directOffer;
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

    @JsonProperty("expirationDate")
    public String getExpirationDate() {
        return expirationDate;
    }

    @JsonProperty("expirationDate")
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @JsonProperty("numberOfOffers")
    public Integer getNumberOfOffers() {
        return numberOfOffers;
    }

    @JsonProperty("numberOfOffers")
    public void setNumberOfOffers(Integer numberOfOffers) {
        this.numberOfOffers = numberOfOffers;
    }

    @JsonProperty("offer")
    public Offer getOffer() {
        return offer;
    }

    @JsonProperty("offer")
    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    @JsonProperty("directOffer")
    public Boolean getDirectOffer() {
        return directOffer;
    }

    @JsonProperty("directOffer")
    public void setDirectOffer(Boolean directOffer) {
        this.directOffer = directOffer;
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
