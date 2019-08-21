
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mins_played",
    "goals",
    "goal_assist",
    "offtarget_att_assist",
    "pen_area_entries",
    "penalty_won",
    "penalty_save",
    "saves",
    "effective_clearance",
    "penalty_failed",
    "own_goals",
    "goals_conceded",
    "yellow_card",
    "second_yellow_card",
    "red_card",
    "total_scoring_att",
    "won_contest",
    "ball_recovery",
    "poss_lost_all",
    "marca_points"
})
public class Stats {

    @JsonProperty("mins_played")
    private List<Integer> minsPlayed = null;
    @JsonProperty("goals")
    private List<Integer> goals = null;
    @JsonProperty("goal_assist")
    private List<Integer> goalAssist = null;
    @JsonProperty("offtarget_att_assist")
    private List<Integer> offtargetAttAssist = null;
    @JsonProperty("pen_area_entries")
    private List<Integer> penAreaEntries = null;
    @JsonProperty("penalty_won")
    private List<Integer> penaltyWon = null;
    @JsonProperty("penalty_save")
    private List<Integer> penaltySave = null;
    @JsonProperty("saves")
    private List<Integer> saves = null;
    @JsonProperty("effective_clearance")
    private List<Integer> effectiveClearance = null;
    @JsonProperty("penalty_failed")
    private List<Integer> penaltyFailed = null;
    @JsonProperty("own_goals")
    private List<Integer> ownGoals = null;
    @JsonProperty("goals_conceded")
    private List<Integer> goalsConceded = null;
    @JsonProperty("yellow_card")
    private List<Integer> yellowCard = null;
    @JsonProperty("second_yellow_card")
    private List<Integer> secondYellowCard = null;
    @JsonProperty("red_card")
    private List<Integer> redCard = null;
    @JsonProperty("total_scoring_att")
    private List<Integer> totalScoringAtt = null;
    @JsonProperty("won_contest")
    private List<Integer> wonContest = null;
    @JsonProperty("ball_recovery")
    private List<Integer> ballRecovery = null;
    @JsonProperty("poss_lost_all")
    private List<Integer> possLostAll = null;
    @JsonProperty("marca_points")
    private List<Integer> marcaPoints = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("mins_played")
    public List<Integer> getMinsPlayed() {
        return minsPlayed;
    }

    @JsonProperty("mins_played")
    public void setMinsPlayed(List<Integer> minsPlayed) {
        this.minsPlayed = minsPlayed;
    }

    @JsonProperty("goals")
    public List<Integer> getGoals() {
        return goals;
    }

    @JsonProperty("goals")
    public void setGoals(List<Integer> goals) {
        this.goals = goals;
    }

    @JsonProperty("goal_assist")
    public List<Integer> getGoalAssist() {
        return goalAssist;
    }

    @JsonProperty("goal_assist")
    public void setGoalAssist(List<Integer> goalAssist) {
        this.goalAssist = goalAssist;
    }

    @JsonProperty("offtarget_att_assist")
    public List<Integer> getOfftargetAttAssist() {
        return offtargetAttAssist;
    }

    @JsonProperty("offtarget_att_assist")
    public void setOfftargetAttAssist(List<Integer> offtargetAttAssist) {
        this.offtargetAttAssist = offtargetAttAssist;
    }

    @JsonProperty("pen_area_entries")
    public List<Integer> getPenAreaEntries() {
        return penAreaEntries;
    }

    @JsonProperty("pen_area_entries")
    public void setPenAreaEntries(List<Integer> penAreaEntries) {
        this.penAreaEntries = penAreaEntries;
    }

    @JsonProperty("penalty_won")
    public List<Integer> getPenaltyWon() {
        return penaltyWon;
    }

    @JsonProperty("penalty_won")
    public void setPenaltyWon(List<Integer> penaltyWon) {
        this.penaltyWon = penaltyWon;
    }

    @JsonProperty("penalty_save")
    public List<Integer> getPenaltySave() {
        return penaltySave;
    }

    @JsonProperty("penalty_save")
    public void setPenaltySave(List<Integer> penaltySave) {
        this.penaltySave = penaltySave;
    }

    @JsonProperty("saves")
    public List<Integer> getSaves() {
        return saves;
    }

    @JsonProperty("saves")
    public void setSaves(List<Integer> saves) {
        this.saves = saves;
    }

    @JsonProperty("effective_clearance")
    public List<Integer> getEffectiveClearance() {
        return effectiveClearance;
    }

    @JsonProperty("effective_clearance")
    public void setEffectiveClearance(List<Integer> effectiveClearance) {
        this.effectiveClearance = effectiveClearance;
    }

    @JsonProperty("penalty_failed")
    public List<Integer> getPenaltyFailed() {
        return penaltyFailed;
    }

    @JsonProperty("penalty_failed")
    public void setPenaltyFailed(List<Integer> penaltyFailed) {
        this.penaltyFailed = penaltyFailed;
    }

    @JsonProperty("own_goals")
    public List<Integer> getOwnGoals() {
        return ownGoals;
    }

    @JsonProperty("own_goals")
    public void setOwnGoals(List<Integer> ownGoals) {
        this.ownGoals = ownGoals;
    }

    @JsonProperty("goals_conceded")
    public List<Integer> getGoalsConceded() {
        return goalsConceded;
    }

    @JsonProperty("goals_conceded")
    public void setGoalsConceded(List<Integer> goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    @JsonProperty("yellow_card")
    public List<Integer> getYellowCard() {
        return yellowCard;
    }

    @JsonProperty("yellow_card")
    public void setYellowCard(List<Integer> yellowCard) {
        this.yellowCard = yellowCard;
    }

    @JsonProperty("second_yellow_card")
    public List<Integer> getSecondYellowCard() {
        return secondYellowCard;
    }

    @JsonProperty("second_yellow_card")
    public void setSecondYellowCard(List<Integer> secondYellowCard) {
        this.secondYellowCard = secondYellowCard;
    }

    @JsonProperty("red_card")
    public List<Integer> getRedCard() {
        return redCard;
    }

    @JsonProperty("red_card")
    public void setRedCard(List<Integer> redCard) {
        this.redCard = redCard;
    }

    @JsonProperty("total_scoring_att")
    public List<Integer> getTotalScoringAtt() {
        return totalScoringAtt;
    }

    @JsonProperty("total_scoring_att")
    public void setTotalScoringAtt(List<Integer> totalScoringAtt) {
        this.totalScoringAtt = totalScoringAtt;
    }

    @JsonProperty("won_contest")
    public List<Integer> getWonContest() {
        return wonContest;
    }

    @JsonProperty("won_contest")
    public void setWonContest(List<Integer> wonContest) {
        this.wonContest = wonContest;
    }

    @JsonProperty("ball_recovery")
    public List<Integer> getBallRecovery() {
        return ballRecovery;
    }

    @JsonProperty("ball_recovery")
    public void setBallRecovery(List<Integer> ballRecovery) {
        this.ballRecovery = ballRecovery;
    }

    @JsonProperty("poss_lost_all")
    public List<Integer> getPossLostAll() {
        return possLostAll;
    }

    @JsonProperty("poss_lost_all")
    public void setPossLostAll(List<Integer> possLostAll) {
        this.possLostAll = possLostAll;
    }

    @JsonProperty("marca_points")
    public List<Integer> getMarcaPoints() {
        return marcaPoints;
    }

    @JsonProperty("marca_points")
    public void setMarcaPoints(List<Integer> marcaPoints) {
        this.marcaPoints = marcaPoints;
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
