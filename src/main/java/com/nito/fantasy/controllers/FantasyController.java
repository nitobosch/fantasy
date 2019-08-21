package com.nito.fantasy.controllers;

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
import com.nito.fantasy.dto.League;
import com.nito.fantasy.dto.Player;
import com.nito.fantasy.dto.Ranking;
import com.nito.fantasy.model.dynamodb.FantasyNewDB;
import com.nito.fantasy.model.dynamodb.FantasyPlayerDB;
import com.nito.fantasy.model.dynamodb.FantasyPlayerHistoryDB;
import com.nito.fantasy.model.marca.FantasyLeague;
import com.nito.fantasy.model.marca.FantasyMarket;
import com.nito.fantasy.model.marca.FantasyRanking;
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

	@RequestMapping(value = "/fantasyJson/leagues", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<League> fantasyLeagues(@RequestParam(name = "token", required = true) String token,
			@RequestParam(name = "updatedb", required = false) String updatedb) {
		List<FantasyLeague> fantasyLeagues = fantasyService.getLeaguesFantasy(token);
		if ("on".equals(updatedb)) {
			fantasyService.updatePlayersFromDB();
		}
		return fantasyLeagues.stream().map(n -> n.convertToDto()).collect(Collectors.toList());
	}

	@RequestMapping(value = "/fantasyJson/market", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Player> fantasyMarket(@RequestParam(name = "token", required = true) String token,
			@RequestParam(name = "league", required = true) String league) {
		List<FantasyMarket> fantasyMarket = fantasyService.getMarketFantasy(token, league);
		return fantasyService.convertToDto(fantasyMarket);
	}

	@RequestMapping(value = "/fantasyJson/ranking", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Ranking> fantasyRanking(@RequestParam(name = "token", required = true) String token,
			@RequestParam(name = "league", required = true) String league) {
		List<FantasyRanking> fantasyRanking = fantasyService.getRankingFantasy(token, league);
		logger.info("updateNewsFromDB:" + league);
		fantasyService.updateNewsFromDB(token, league);
		logger.info("updateFantasyLeaguePlayersFromDB:" + league);
		fantasyService.updateFantasyLeaguePlayersFromDB(token, league);
		return fantasyService.convertToDtoRanking(league, fantasyRanking);
	}

	@RequestMapping(value = "/fantasyJson/players", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Player> fantasyLeaguePlayers(@RequestParam(name = "token", required = false) String token,
			@RequestParam(name = "teams", required = false) String teams,
			@RequestParam(name = "diffValueBuyoutClause", required = false) String diffValueBuyoutClause,
			@RequestParam(name = "daysBuyoutClause", required = false) String daysBuyoutClause,
			@RequestParam(name = "league", required = true) String league,
			@RequestParam(name = "updatedb", required = false) String updatedb,
			@RequestParam(name = "allplayers", required = false) String allplayers) {
		logger.info("LocalDateTime.now().plusDays(1):" + LocalDateTime.now().plusDays(1));
		logger.info("teams:" + teams);
		logger.info("diffValueBuyoutClause:" + diffValueBuyoutClause);
		logger.info("daysBuyoutClause:" + daysBuyoutClause);
		logger.info("league:" + league);
		logger.info("updatedb:" + updatedb);
		logger.info("allplayers:" + allplayers);
		List<String> teamsList = new ArrayList<>(Arrays.asList(teams.split(",")));
		logger.info("teamsList.size():" + teamsList.size());
		List<Player> leaguePlayers = new ArrayList<>();
		List<String> leaguePlayersId = new ArrayList<>();
		List<Player> allPlayers = new ArrayList<>();
		List<Player> players = new ArrayList<>();
		if ("on".equals(updatedb)) {
			fantasyService.updatePlayersFromDB();
			fantasyService.updateFantasyLeaguePlayersFromDB(token, league);
		}
		leaguePlayers = fantasyService.convertToDtoFromLeaguePlayersDB(fantasyService.getFantasyLeaguePlayersFromDB(league));
		leaguePlayersId = leaguePlayers.stream().map(n -> n.getPlayerId()).collect(Collectors.toList());
		logger.info("leaguePlayers.size():" + leaguePlayers.size());
		if ("on".equals(allplayers)) {
			allPlayers = fantasyService.getFantasyPlayersFromDB().stream().map(n -> n.convertToDto())
					.collect(Collectors.toList());
			logger.info("allPlayers.size():" + allPlayers.size());
		}
		players.addAll(leaguePlayers);
		logger.info("1-players.size():" + players.size());
		for (Player objPlayer : allPlayers) {
			logger.info("objPlayer:" + objPlayer.getPlayerId() + " - " + objPlayer.getPlayerName());
			if (!leaguePlayersId.contains(objPlayer.getPlayerId())) {
				logger.info("objPlayer add");
				players.add(objPlayer);
			}
		}
		logger.info("2-players.size():" + players.size());
		return players.stream()
				.filter(n -> "".equals(diffValueBuyoutClause) || diffValueBuyoutClause == null
						|| (n.getPlayerBuyoutClause() - n.getPlayerValue() <= (Integer.valueOf(diffValueBuyoutClause) * 1000000)))
				.filter(n -> "on".equals(allplayers) || "".equals(teams) || teams == null || teamsList == null
						|| teamsList.size() == 0 || teamsList.contains(n.getTeamId()))
				.filter(n -> "".equals(daysBuyoutClause) || daysBuyoutClause == null
						|| n.getPlayerEndBuyoutClause().isBefore(LocalDateTime.now().plusDays(Integer.valueOf(daysBuyoutClause))))
				.collect(Collectors.toList());
	}

}
