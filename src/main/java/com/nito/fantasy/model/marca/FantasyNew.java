
package com.nito.fantasy.model.marca;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.nito.fantasy.model.dynamodb.FantasyNewDB;
import com.nito.fantasy.model.dynamodb.FantasyPlayerHistoryDB;
import com.nito.fantasy.services.FantasyService;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "isComentable",
    "numberOfComments",
    "id",
    "title",
    "msg",
    "translations",
    "publicationDate",
    "leagueType",
    "leagueId"
})
public class FantasyNew {
	private static final Logger logger = Logger.getLogger(FantasyNew.class);

    @JsonProperty("isComentable")
    private Boolean isComentable;
    @JsonProperty("numberOfComments")
    private Integer numberOfComments;
    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("translations")
    private List<Object> translations = null;
    @JsonProperty("publicationDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private LocalDateTime publicationDate;
    @JsonProperty("leagueType")
    private String leagueType;
    @JsonProperty("leagueId")
    private Integer leagueId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("isComentable")
    public Boolean getIsComentable() {
        return isComentable;
    }

    @JsonProperty("isComentable")
    public void setIsComentable(Boolean isComentable) {
        this.isComentable = isComentable;
    }

    @JsonProperty("numberOfComments")
    public Integer getNumberOfComments() {
        return numberOfComments;
    }

    @JsonProperty("numberOfComments")
    public void setNumberOfComments(Integer numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("msg")
    public String getMsg() {
        return msg;
    }

    @JsonProperty("msg")
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @JsonProperty("translations")
    public List<Object> getTranslations() {
        return translations;
    }

    @JsonProperty("translations")
    public void setTranslations(List<Object> translations) {
        this.translations = translations;
    }

    @JsonProperty("publicationDate")
    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    @JsonProperty("publicationDate")
    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
    public String getPlayerName() {
    	String name = null;
		name = this.msg.substring(this.msg.indexOf(" a ")+3, this.msg.indexOf(" a ", this.msg.indexOf(" a ")+1));
    	return name;
    }
    
    public String getPartnerName() {
    	String name = null;
		name = this.msg.substring(this.msg.indexOf(" a ", this.msg.indexOf(" a ")+1)+3, this.msg.indexOf(" por "));
    	return name;
    }
    
    public String getManagerName() {
    	String name = null;
		name = this.msg.substring(0,this.msg.indexOf(" ha "));
    	return name;
    }
    
    public Integer getMoney() {
    	String s_money = null;
    	s_money = this.msg.substring(this.msg.indexOf(" por ")+5, this.msg.indexOf(" €"));
    	return Integer.valueOf(s_money.replace(".", ""));
    }
    
    public String getOperation() {
    	String name = null;
		if (this.msg.contains("comprado")) {
			name = "purchase";
		}else if (this.msg.contains("vendido")) {
			name = "sale";
		}
    	return name;
    }
	
	public FantasyNewDB convertToEntityDB(String leagueId) {
		FantasyNewDB fantasyNew = new FantasyNewDB();
		fantasyNew.setId(this.id);
		fantasyNew.setTitle(this.title);
		fantasyNew.setMsg(this.msg);
		fantasyNew.setLeagueId(leagueId);
		fantasyNew.setDate(this.publicationDate);
		fantasyNew.setPlayerName(this.getPlayerName());
		fantasyNew.setPartnerName(this.getPartnerName());
		fantasyNew.setMoney(this.getMoney());
		fantasyNew.setOperation(this.getOperation());
		fantasyNew.setManagerName(this.getManagerName());
		return fantasyNew;
	}

}
