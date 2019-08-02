package com.nito.fantasy.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nito.fantasy.FantasyController;
import com.nito.fantasy.entity.Player;
import com.nito.fantasy.entity.Ranking;
import com.nito.fantasy.model.FantasyHistory;
import com.nito.fantasy.model.FantasyPlayerMarket;
import com.nito.fantasy.model.FantasyRanking;
import com.nito.fantasy.model.FantasyTeam;
import com.nito.fantasy.util.Formatter;

@Service
public class FantasyService {
	private static final Logger logger = Logger.getLogger(FantasyService.class);
	
    public List<FantasyRanking> getRankingFantasy(String authToken) {
    	
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));        
        headers.add("Authorization", "Bearer "+authToken );
        
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.laligafantasymarca.com/api/v4/leagues/0149334/ranking";
        ResponseEntity<List<FantasyRanking>> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers), new ParameterizedTypeReference<List<FantasyRanking>>(){});
        List<FantasyRanking> fantasyRanking = response.getBody();
        return fantasyRanking;
    }
	
    public FantasyTeam getTeamFantasy(String authToken, String teamId) {
    	
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));        
        headers.add("Authorization", "Bearer "+authToken );
        
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.laligafantasymarca.com/api/v3/leagues/0149334/teams/" + teamId;
    	logger.info("url:"+url);
        ResponseEntity<FantasyTeam> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers), new ParameterizedTypeReference<FantasyTeam>(){});
        FantasyTeam fantasyTeams = response.getBody();
    	logger.info("fantasyTeams.getId():"+fantasyTeams.getId());
        return fantasyTeams;
    }
	
    public List<FantasyPlayerMarket> getPlayerMarketFantasy(String playerId) {
    	
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.laligafantasymarca.com/api/v3/player/" + playerId + "/market-value";
    	logger.info("url:"+url);
        ResponseEntity<List<FantasyPlayerMarket>> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers), new ParameterizedTypeReference<List<FantasyPlayerMarket>>(){});
        List<FantasyPlayerMarket> fantasyPlayerMarket = response.getBody();
        return fantasyPlayerMarket;
    }
	
    public List<FantasyHistory> getHistoryFantasy(String authToken) {
    	
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));        
        headers.add("Authorization", "Bearer "+authToken );
        
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.laligafantasymarca.com/api/v3/league/0149334/market/history";
    	logger.info("url:"+url);
        ResponseEntity<List<FantasyHistory>> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers), new ParameterizedTypeReference<List<FantasyHistory>>(){});
        List<FantasyHistory> fantasyHistory = response.getBody();
        return fantasyHistory;
    }
    
    public List<Player> convertToDto(List<FantasyTeam> fantasyTeams){
    	List<Player> players = new ArrayList<Player>();
    	for (FantasyTeam team: fantasyTeams) 
        { 
    		String managerName = team.getManager().getManagerName();
        	for (com.nito.fantasy.model.Player player: team.getPlayers()) 
            { 
        		Player newPlayer = new Player();
        		newPlayer.setManagerName(managerName);
        		newPlayer.setPlayerId(player.getPlayerMaster().getId());
        		newPlayer.setPlayerName(player.getPlayerMaster().getNickname());
        		newPlayer.setPlayerPoints(player.getPlayerMaster().getPoints());
        		newPlayer.setPlayerPointsAA(player.getPlayerMaster().getLastSeasonPoints());
        		newPlayer.setPlayerValue(player.getPlayerMaster().getMarketValue());
        		newPlayer.setPlayerPointsAA(player.getPlayerMaster().getLastSeasonPoints());
        		newPlayer.setPlayerValue(player.getPlayerMaster().getMarketValue());
        		newPlayer.setPlayerValueFormatted(Formatter.formatNumber(player.getPlayerMaster().getMarketValue()));
        		newPlayer.setPlayerBuyoutClause(player.getBuyoutClause());
        		newPlayer.setPlayerBuyoutClauseFormatted(Formatter.formatNumber(player.getBuyoutClause()));
        		newPlayer.setPlayerEndBuyoutClause(Formatter.parseDate(player.getBuyoutClauseLockedEndTime()));
        		newPlayer.setPlayerEndBuyoutClauseFormatted(Formatter.formatDate(player.getBuyoutClauseLockedEndTime()));
        		
        		List<FantasyPlayerMarket> playerMarket = getPlayerMarketFantasy(player.getPlayerMaster().getId());
        		
        		Integer valoyHoy = playerMarket.get(playerMarket.size()-1).getMarketValue();
        		Integer valoyAyer = playerMarket.get(playerMarket.size()-2).getMarketValue();
        		Integer diffValor = valoyHoy - valoyAyer;
        		newPlayer.setMarketValue(valoyHoy);
        		newPlayer.setMarketValueFormatted(Formatter.formatNumber(valoyHoy));
        		newPlayer.setDiffMarketValue(diffValor);
        		newPlayer.setDiffMarketValueFormatted(Formatter.formatNumber(diffValor));
        		if(diffValor > 0) {
            		newPlayer.setUpDownMarketValue("UP");
        		}else if(diffValor < 0) {
            		newPlayer.setUpDownMarketValue("DOWN");
        		}else {
            		newPlayer.setUpDownMarketValue("=");
        		}
        		
        		players.add(newPlayer);
            } 
        } 
    	return players;
    }
    
    public List<Player> putHistory(String authToken, List<Player> players){
    	List<FantasyHistory> history = new ArrayList<FantasyHistory>();
    	history = getHistoryFantasy(authToken);
    	for (Player player: players) 
        { 
        		
        } 
    	return players;
    }

}
