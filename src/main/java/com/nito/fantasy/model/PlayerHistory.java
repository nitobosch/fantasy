
package com.nito.fantasy.model;

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
    "images",
    "id",
    "name",
    "nickname",
    "positionId",
    "image30x30",
    "image250x250",
    "image96x96"
})
public class PlayerHistory {

    @JsonProperty("images")
    private Images images;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("positionId")
    private Integer positionId;
    @JsonProperty("image30x30")
    private String image30x30;
    @JsonProperty("image250x250")
    private String image250x250;
    @JsonProperty("image96x96")
    private String image96x96;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("nickname")
    public String getNickname() {
        return nickname;
    }

    @JsonProperty("nickname")
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @JsonProperty("positionId")
    public Integer getPositionId() {
        return positionId;
    }

    @JsonProperty("positionId")
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
