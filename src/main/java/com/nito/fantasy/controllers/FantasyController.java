package com.nito.fantasy.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.nito.fantasy.dto.League;
import com.nito.fantasy.dto.Player;
import com.nito.fantasy.dto.Ranking;
import com.nito.fantasy.model.dynamodb.FantasyNewDB;
import com.nito.fantasy.model.dynamodb.FantasyPlayerDB;
import com.nito.fantasy.model.dynamodb.FantasyLeaguePlayerDB;
import com.nito.fantasy.model.dynamodb.FantasyPlayerHistoryDB;
import com.nito.fantasy.model.dynamodb.FantasyPlayerMarketDB;
import com.nito.fantasy.model.marca.FantasyLeague;
import com.nito.fantasy.model.marca.FantasyMarket;
import com.nito.fantasy.model.marca.FantasyRanking;
import com.nito.fantasy.model.marca.FantasyTeam;
import com.nito.fantasy.repositories.dynamodb.FantasyPlayerHistoryDBRepository;
import com.nito.fantasy.services.FantasyService;

@Controller
public class FantasyController {
	private static final Logger logger = Logger.getLogger(FantasyController.class);
	
    private DynamoDBMapper dynamoDBMapper;
    
    @Autowired
    private AmazonDynamoDB amazonDynamoDB;
    
    @Autowired
    private FantasyService fantasyService;
 
    public FantasyController(FantasyService fantasyService) {
        this.fantasyService = fantasyService;
    }
    
	@GetMapping("/")
    public String index() {
        return "home";
    }
    
	@GetMapping("/players")
    public String players() {
        return "players";
    }
    
	@GetMapping("/market")
    public String market() {
        return "market";
    }
    
    @RequestMapping(value = "/update/history", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<FantasyPlayerHistoryDB> udpatehistorydb(@RequestParam(name="token", required=true) String token, @RequestParam(name="league", required=true) String league) {
        return fantasyService.updatePlayersHistoryfromDB(token, league);
    }
    
    @RequestMapping(value = "/update/news", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<FantasyNewDB> udpatenewsdb(
    		@RequestParam(name="token", required=true) String token, 
    		@RequestParam(name="league", required=true) String league) {
        return fantasyService.updateAllNewsfromDB(token, league);
    }
    
    @RequestMapping(value = "/update/players", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<FantasyPlayerDB> udpatePlayers() {
    	logger.info("udpateAllPlayers");
    	fantasyService.updatePlayersFromDB();
        return fantasyService.getFantasyPlayersFromDB();
    }
    
    @RequestMapping(value = "/fantasyJson/market", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Player> fantasyMarket(
    		@RequestParam(name="token", required=true) String token, 
    		@RequestParam(name="league", required=true) String league) {
        List<FantasyMarket> fantasyMarket = fantasyService.getMarketFantasy(token, league);
        return fantasyService.convertToDtoPlayersMarket(fantasyMarket);
    }
    
    @RequestMapping(value = "/fantasyJson/leagues", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<League> fantasyLeagues(@RequestParam(name="token", required=true) String token) {
        List<FantasyLeague> fantasyRanking = fantasyService.getLeaguesFantasy(token);
        return fantasyRanking.stream()
        		.map(n -> n.convertToDto())
        		.collect(Collectors.toList());
    }
    
    @RequestMapping(value = "/fantasyJson/ranking", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Ranking> fantasyRanking(
    		@RequestParam(name="token", required=true) String token, 
    		@RequestParam(name="league", required=true) String league) {
        List<FantasyRanking> fantasyRanking = fantasyService.getRankingFantasy(token,league);
    	fantasyService.updateNewsFromDB(token, league);
        return fantasyService.convertToDtoRanking(league, fantasyRanking);
    }
    
    @RequestMapping(value = "/fantasyJson/rankingupdate", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Ranking> fantasyRankingUpdate(
    		@RequestParam(name="token", required=true) String token, 
    		@RequestParam(name="league", required=true) String league) {
    	List<FantasyRanking> fantasyRanking = fantasyService.getRankingFantasy(token,league);
        return fantasyRanking.stream()
        		.map(n -> n.convertToDto())
        		.collect(Collectors.toList());
    }
    
    @RequestMapping(value = "/fantasyJson/leagueplayers", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Player> fantasyLeaguePlayers(
    		@RequestParam(name="token", required=false) String token, 
    		@RequestParam(name="teams", required=false) String teams, 
    		@RequestParam(name="diffValueBuyoutClause", required=false) Integer diffValueBuyoutClause, 
    		@RequestParam(name="daysBuyoutClause", required=false) Integer daysBuyoutClause, 
    		@RequestParam(name="league", required=true) String league,
    		@RequestParam(name="updatedb", required=false) String updatedb) {
    	logger.info("LocalDateTime.now().plusDays(1):"+LocalDateTime.now().plusDays(1));
    	logger.info("teams:"+teams);
    	logger.info("diffValueBuyoutClause:"+diffValueBuyoutClause);
    	logger.info("daysBuyoutClause:"+daysBuyoutClause);
    	logger.info("league:"+league);
    	logger.info("updatedb:"+updatedb);
    	if("on".equals(updatedb)) {
        	fantasyService.updateFantasyLeaguePlayers(token, league);
    	}
    	List<String> teamsList = new ArrayList<>(Arrays.asList(teams.split(",")));
    	logger.info("teamsList.size():"+teamsList.size());
        return fantasyService.getFantasyLeaguePlayersFromDB(league)
			  .stream()
			  .map(n -> n.convertToDto())
			  .filter(n -> diffValueBuyoutClause == null || (n.getPlayerBuyoutClause() - n.getPlayerValue() < (diffValueBuyoutClause*1000000)))
			  .filter(n -> "".equals(teams) || teams == null || teamsList == null || teamsList.size() == 0 || teamsList.contains(n.getTeamId()))
			  .filter(n -> daysBuyoutClause == null || n.getPlayerEndBuyoutClause().isBefore(LocalDateTime.now().plusDays(daysBuyoutClause)))
			  .collect(Collectors.toList());
    }
    
    @RequestMapping(value = "/fantasyJson/players", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Player> fantasyPlayers(
    		@RequestParam(name="updatedb", required=false) String updatedb) {
    	logger.info("updatedb:"+updatedb);
    	if("on".equals(updatedb)) {
        	fantasyService.updatePlayersFromDB();
    	}
        return fantasyService.getFantasyPlayers();
    }
    
}
