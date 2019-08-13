package com.nito.fantasy.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.nito.fantasy.dto.Player;
import com.nito.fantasy.dto.PlayerPosition;
import com.nito.fantasy.model.dynamodb.FantasyNewDB;
import com.nito.fantasy.model.dynamodb.FantasyPlayerDB;
import com.nito.fantasy.model.dynamodb.FantasyPlayerHistoryDB;
import com.nito.fantasy.model.marca.FantasyHistory;
import com.nito.fantasy.model.marca.FantasyLeague;
import com.nito.fantasy.model.marca.FantasyMarket;
import com.nito.fantasy.model.marca.FantasyNew;
import com.nito.fantasy.model.marca.FantasyPlayerMarket;
import com.nito.fantasy.model.marca.FantasyRanking;
import com.nito.fantasy.model.marca.FantasyTeam;
import com.nito.fantasy.repositories.dynamodb.FantasyNewDBRepository;
import com.nito.fantasy.repositories.dynamodb.FantasyPlayerDBRepository;
import com.nito.fantasy.repositories.dynamodb.FantasyPlayerHistoryDBRepository;
import com.nito.fantasy.util.Formatter;

@Service
public class FantasyService {
	private static final Logger logger = Logger.getLogger(FantasyService.class);

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    private FantasyPlayerDBRepository fantasyPlayerDBRepository;

    @Autowired
    private FantasyPlayerHistoryDBRepository fantasyPlayerHistoryDBRepository;

    @Autowired
    private FantasyNewDBRepository fantasyNewDBRepository;
	
    public List<FantasyLeague> getLeaguesFantasy(String authToken) {
    	
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));        
        headers.add("Authorization", "Bearer "+authToken );
        
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.laligafantasymarca.com/api/v4/leagues";
        ResponseEntity<List<FantasyLeague>> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers), new ParameterizedTypeReference<List<FantasyLeague>>(){});
        List<FantasyLeague> fantasyLeagues = response.getBody();
        return fantasyLeagues;
    }
	
    public List<FantasyRanking> getRankingFantasy(String authToken, String leagueId) {
    	
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));        
        headers.add("Authorization", "Bearer "+authToken );
        
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.laligafantasymarca.com/api/v4/leagues/"+leagueId+"/ranking";
        logger.info(url);
        ResponseEntity<List<FantasyRanking>> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers), new ParameterizedTypeReference<List<FantasyRanking>>(){});
        List<FantasyRanking> fantasyRanking = response.getBody();
        return fantasyRanking;
    }
	
    public List<FantasyMarket> getMarketFantasy(String authToken, String leagueId) {
    	
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));        
        headers.add("Authorization", "Bearer "+authToken );
        
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.laligafantasymarca.com/api/v3/league/"+leagueId+"/market";
        ResponseEntity<List<FantasyMarket>> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers), new ParameterizedTypeReference<List<FantasyMarket>>(){});
        List<FantasyMarket> fantasyMarket = response.getBody();
        return fantasyMarket;
    }
	
    public FantasyTeam getTeamFantasy(String authToken, String leagueId, String teamId) {
    	
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));        
        headers.add("Authorization", "Bearer "+authToken );
        
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.laligafantasymarca.com/api/v3/leagues/"+leagueId+"/teams/" + teamId;
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
	
    public List<FantasyHistory> getHistoryFantasy(String authToken, String league) {
    	
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));        
        headers.add("Authorization", "Bearer "+authToken );
        
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.laligafantasymarca.com/api/v3/league/"+league+"/market/history";
    	logger.info("url:"+url);
        ResponseEntity<List<FantasyHistory>> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers), new ParameterizedTypeReference<List<FantasyHistory>>(){});
        List<FantasyHistory> fantasyHistory = response.getBody();
        return fantasyHistory;
    }
	
    public List<FantasyNew> getNewsFantasy(String authToken, String league) {
    	
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));        
        headers.add("Authorization", "Bearer "+authToken );
        
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.laligafantasymarca.com/api/v3/leagues/"+league+"/news/1";
    	logger.info("url:"+url);
        ResponseEntity<List<FantasyNew>> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers), new ParameterizedTypeReference<List<FantasyNew>>(){});
        List<FantasyNew> fantasyNews = response.getBody();
        return fantasyNews;
    }
    
    public List<Player> convertToDtoPlayersMarket(List<FantasyMarket> fantasyMarket){
    	List<Player> players = new ArrayList<Player>();
    	for (FantasyMarket player: fantasyMarket) 
        { 
    		if ("marketPlayerLeague".equals(player.getDiscr())) {
        		Player newPlayer = new Player();
        		newPlayer.setPlayerId(player.getPlayerMaster().getId());
        		newPlayer.setPlayerName(player.getPlayerMaster().getNickname());
        		newPlayer.setPlayerPoints(player.getPlayerMaster().getPoints());
        		newPlayer.setPlayerPointsAA(player.getPlayerMaster().getLastSeasonPoints());
        		newPlayer.setPlayerValue(player.getPlayerMaster().getMarketValue());
        		newPlayer.setPlayerPointsAA(player.getPlayerMaster().getLastSeasonPoints());
        		newPlayer.setPlayerValue(player.getPlayerMaster().getMarketValue());
        		newPlayer.setPlayerValueFormatted(Formatter.formatNumber(player.getPlayerMaster().getMarketValue()));
        		newPlayer.setPlayerNumBids(player.getNumberOfBids());
        		newPlayer.setPlayerImage(player.getPlayerMaster().getImages().getTransparent().get64x64());
        		newPlayer.setPlayerTeamName(player.getPlayerMaster().getTeam().getName());
        		newPlayer.setPlayerTeamImage(player.getPlayerMaster().getTeam().getBadgeColor());
        		newPlayer.setPlayerPosition(player.getPlayerMaster().getPositionId());
        		
        		List<FantasyPlayerMarket> playerMarket = getPlayerMarketFantasy(player.getPlayerMaster().getId());
        		if (playerMarket != null && playerMarket.size() > 1) {
            		newPlayer.setUpDownYesterday(playerMarket.get(playerMarket.size()-2).getMarketValue());
        		}
        		
        		players.add(newPlayer);	
    		}
        } 
    	return players;
    }
    
    public List<Player> convertToDtoPlayers(String authToken, List<FantasyTeam> fantasyTeams){
    	List<Player> players = new ArrayList<Player>();
    	List<FantasyHistory> fantasyHistory = new ArrayList<FantasyHistory>();
    	fantasyHistory = getHistoryFantasy(authToken, "0149334");
    	for (FantasyTeam team: fantasyTeams) 
        { 
    		String managerName = team.getManager().getManagerName();
        	for (com.nito.fantasy.model.marca.Player player: team.getPlayers()) 
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
//        		newPlayer.setPlayerEndBuyoutClause(Formatter.parseDate(player.getBuyoutClauseLockedEndTime()));
//        		newPlayer.setPlayerEndBuyoutClauseFormatted(Formatter.formatDate(player.getBuyoutClauseLockedEndTime()));
        		
        		List<FantasyPlayerMarket> playerMarket = getPlayerMarketFantasy(player.getPlayerMaster().getId());
        		newPlayer.setUpDownYesterday(playerMarket.get(playerMarket.size()-2).getMarketValue());
        		
        		FantasyHistory playerBuyDate = fantasyHistory.stream()
        				  .filter(p -> "purchase".equals(p.getOperation()))
        				  .filter(p -> player.getPlayerMaster().getId().equals(p.getPlayer().getId()))
        				  .findAny()
        				  .orElse(null);
        		
        		if (playerBuyDate != null) {
            		Integer marketValueBuyDate = playerMarket.stream()
            				  .filter(p -> p.getDate().getYear() == playerBuyDate.getDate().getYear() && p.getDate().getDayOfYear() == playerBuyDate.getDate().getDayOfYear())
            				  .findAny()
            				  .orElse(null)
            				  .getMarketValue();
            		
            		newPlayer.setUpDownPurchaseDate(playerBuyDate.getDate(), playerBuyDate.getMoney(), marketValueBuyDate);	
        		}
        		
        		players.add(newPlayer);
            } 
        } 
    	return players;
    }
	
    public List<FantasyPlayerHistoryDB> updatePlayersHistoryfromDB(String authToken, String leagueId) {

    	List<FantasyPlayerHistoryDB> playersHistoryDB = getFantasyPlayersHistoryFromDB(leagueId);

    	List<FantasyHistory> fantasyHistory = getHistoryFantasy(authToken, leagueId);

    	for (FantasyHistory historyObj: fantasyHistory){ 
        	logger.info("Player:"+historyObj.getPlayer().getId()+" - "+historyObj.getPlayer().getNickname());
    		FantasyPlayerHistoryDB playerDB = null;
    		if (playersHistoryDB != null) {
    			playerDB = playersHistoryDB.stream()
      				  .filter(p -> historyObj.getOperation().equals(p.getOperation()))
      				  .filter(p -> historyObj.getPlayer().getId().equals(p.getPlayerId()))
      				  .findAny()
      				  .orElse(null);	
    		}    		
    		if (playerDB != null) {
    			playerDB.setDate(historyObj.getDate());
    			playerDB.setMoney(historyObj.getMoney());
    			fantasyPlayerHistoryDBRepository.save(playerDB);
    		}else {
    			playerDB = historyObj.convertToEntityDB(leagueId);
    			fantasyPlayerHistoryDBRepository.save(playerDB);
    		}
    	}

    	
//    	FantasyTeam teamNito = getTeamFantasy(authToken, leagueId, "252706");
//		playersHistoryDB = fantasyPlayerHistoryDBRepository.findByLeagueId(leagueId); 
//		
//    	for (com.nito.fantasy.model.marca.Player player: teamNito.getPlayers()){ 
//    		FantasyPlayerHistoryDB playerDB = null;
//    		if (playersHistoryDB != null) {
//    			playerDB = playersHistoryDB.stream()
//      				  .filter(p -> "purchase".equals(p.getOperation()))
//      				  .filter(p -> player.getPlayerMaster().getId().equals(p.getPlayerId()))
//      				  .findAny()
//      				  .orElse(null);	
//    		}    		
//    		if (playerDB == null) {
//    			playerDB = player.convertToEntityDB(leagueId);
//    			fantasyPlayerHistoryDBRepository.save(playerDB);
//    		}
//        } 
    	
    	return (List<FantasyPlayerHistoryDB>) fantasyPlayerHistoryDBRepository.findByLeagueId(leagueId); 
    }
	
    public List<FantasyPlayerDB> updatePlayersfromDB(String authToken, String leagueId) {

    	List<FantasyPlayerDB> playersDB = clearFantasyPlayersFromDB(leagueId);
    	List<FantasyPlayerDB> new_playersDB = new ArrayList<>();
    	List<FantasyPlayerHistoryDB> playersHistoryDB = updatePlayersHistoryfromDB(authToken, leagueId);
    	List<FantasyNewDB> playersNewsDB = updateNewsfromDB(authToken, leagueId);
    	
        List<FantasyRanking> fantasyRanking = getRankingFantasy(authToken, leagueId);

    	for (FantasyRanking rankingObj: fantasyRanking){
    		FantasyTeam team = getTeamFantasy(authToken, leagueId, rankingObj.getTeam().getId()); 
        	for (com.nito.fantasy.model.marca.Player player: team.getPlayers()){
        		FantasyPlayerDB newPlayer = new FantasyPlayerDB();
        		newPlayer.setLeagueId(leagueId);
        		newPlayer.setPlayerId(player.getPlayerMaster().getId());
        		newPlayer.setPlayerName(player.getPlayerMaster().getNickname());
        		newPlayer.setManagerName(team.getManager().getManagerName());
        		newPlayer.setTeamId(team.getId());
        		newPlayer.setPlayerPoints(player.getPlayerMaster().getPoints());
        		newPlayer.setPlayerPointsAA(player.getPlayerMaster().getLastSeasonPoints());
        		newPlayer.setPlayerMarketValue(player.getPlayerMaster().getMarketValue());
        		newPlayer.setPlayerBuyoutClause(player.getBuyoutClause());
        		newPlayer.setPlayerEndBuyoutClause(player.getBuyoutClauseLockedEndTime());
        		newPlayer.setPlayerImage(player.getPlayerMaster().getImages().getTransparent().get64x64());
        		newPlayer.setPlayerTeam(player.getPlayerMaster().getTeam().getName());
        		newPlayer.setPlayerTeamImage(player.getPlayerMaster().getTeam().getBadgeColor());
        		newPlayer.setPlayerPositionId(player.getPlayerMaster().getPositionId());

        		List<FantasyPlayerMarket> playerMarket = getPlayerMarketFantasy(player.getPlayerMaster().getId());
        		
        		if (playerMarket != null) {
        			newPlayer.setPlayerMarketValueYesterday(playerMarket.get(playerMarket.size()-2).getMarketValue());
            		
            		FantasyPlayerHistoryDB playerPurchase = playersHistoryDB.stream()
            				  .filter(p -> "purchase".equals(p.getOperation()))
            				  .filter(p -> player.getPlayerMaster().getId().equals(p.getPlayerId()))
            				  .filter(p -> leagueId.equals(p.getLeagueId()))
            				  .filter(p -> p.getDate() != null)
            				  .sorted(Comparator.comparing(FantasyPlayerHistoryDB::getDate).reversed())
            				  .findFirst()
            				  .orElse(null);
            		
            		FantasyNewDB playerNewPurchase = playersNewsDB.stream()
            				  .filter(p -> "purchase".equals(p.getOperation()))
            				  .filter(p -> player.getPlayerMaster().getNickname().equals(p.getPlayerName()))
            				  .filter(p -> leagueId.equals(p.getLeagueId()))
            				  .filter(p -> p.getDate() != null)
            				  .sorted(Comparator.comparing(FantasyNewDB::getDate).reversed())
            				  .findFirst()
            				  .orElse(null);
            		
            		if (playerPurchase != null) {
                		Integer marketValuePurchaseDate = playerMarket.stream()
                				  .filter(p -> p.getDate().getYear() == playerPurchase.getDate().getYear() && p.getDate().getDayOfYear() == playerPurchase.getDate().getDayOfYear())
                				  .findAny()
                				  .orElse(null)
                				  .getMarketValue();
                		newPlayer.setPlayerPurchaseDate(playerPurchase.getDate());
                		newPlayer.setPlayerMarketValuePurchaseDate(marketValuePurchaseDate);
                		newPlayer.setPlayerPurchaseAmount(playerPurchase.getMoney());
            		}else if (playerNewPurchase != null) {
                		Integer marketValuePurchaseDate = playerMarket.stream()
              				  .filter(p -> p.getDate().getYear() == playerNewPurchase.getDate().getYear() && p.getDate().getDayOfYear() == playerNewPurchase.getDate().getDayOfYear())
              				  .findAny()
              				  .orElse(null)
              				  .getMarketValue();
	              		newPlayer.setPlayerPurchaseDate(playerNewPurchase.getDate());
	              		newPlayer.setPlayerMarketValuePurchaseDate(marketValuePurchaseDate);
	              		newPlayer.setPlayerPurchaseAmount(playerNewPurchase.getMoney());
            		}
        		}    
        		new_playersDB.add(newPlayer);
        	}
    	}
    	fantasyPlayerDBRepository.saveAll(new_playersDB);
    	
    	return fantasyPlayerDBRepository.findByLeagueId(leagueId); 
    }
	
    public List<FantasyNewDB> updateNewsfromDB(String authToken, String leagueId) {

    	List<FantasyNewDB> newsDB = getFantasyNewsFromDB(leagueId);

    	List<FantasyNew> fantasyNews = getNewsFantasy(authToken, leagueId);

    	for (FantasyNew obj: fantasyNews){ 
        	logger.info("Title:"+obj.getMsg());
    		FantasyNewDB objDB = null;
    		if ("Operación de mercado".equals(obj.getTitle())) {
        		if (newsDB != null) {
        			objDB = newsDB.stream()
          				  .filter(p -> obj.getId().equals(p.getId()))
          				  .findAny()
          				  .orElse(null);	
        		}    		
        		if (objDB == null) {
        			objDB = obj.convertToEntityDB(leagueId);
        			fantasyNewDBRepository.save(objDB);
        		}
    		}
    	}
    	
    	return (List<FantasyNewDB>) fantasyNewDBRepository.findByLeagueId(leagueId); 
    }
	
    public List<FantasyPlayerDB> clearFantasyPlayersFromDB(String leagueId) {

    	List<FantasyPlayerDB> players = new ArrayList<>();
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
        CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(FantasyPlayerDB.class);
        tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
        TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);
        players = (List<FantasyPlayerDB>) fantasyPlayerDBRepository.findByLeagueId(leagueId);
        fantasyPlayerDBRepository.deleteAll(players);
        
        return players;
    }
	
    public List<FantasyPlayerDB> getFantasyPlayersFromDB(String leagueId) {

    	List<FantasyPlayerDB> players = new ArrayList<>();
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
        CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(FantasyPlayerDB.class);
        tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
        TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);
        players = (List<FantasyPlayerDB>) fantasyPlayerDBRepository.findByLeagueId(leagueId);
        
        return players;
    }
	
    public List<FantasyPlayerHistoryDB> getFantasyPlayersHistoryFromDB(String leagueId) {

    	List<FantasyPlayerHistoryDB> players = new ArrayList<>();
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
        CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(FantasyPlayerHistoryDB.class);
        tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
        TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);
        players = (List<FantasyPlayerHistoryDB>) fantasyPlayerHistoryDBRepository.findByLeagueId(leagueId);
        
        return players;
    }
	
    public List<FantasyNewDB> getFantasyNewsFromDB(String leagueId) {

    	List<FantasyNewDB> news = new ArrayList<>();
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
        CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(FantasyNewDB.class);
        tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
        TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);
        news = (List<FantasyNewDB>) fantasyNewDBRepository.findByLeagueId(leagueId);
        
        return news;
    }
}
