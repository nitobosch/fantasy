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
import com.nito.fantasy.dto.Ranking;
import com.nito.fantasy.model.dynamodb.FantasyLeaguePlayerDB;
import com.nito.fantasy.model.dynamodb.FantasyNewDB;
import com.nito.fantasy.model.dynamodb.FantasyPlayerDB;
import com.nito.fantasy.model.dynamodb.FantasyPlayerHistoryDB;
import com.nito.fantasy.model.dynamodb.FantasyPlayerMarketDB;
import com.nito.fantasy.model.marca.FantasyHistory;
import com.nito.fantasy.model.marca.FantasyLeague;
import com.nito.fantasy.model.marca.FantasyMarket;
import com.nito.fantasy.model.marca.FantasyNew;
import com.nito.fantasy.model.marca.FantasyPlayer;
import com.nito.fantasy.model.marca.FantasyPlayerMarket;
import com.nito.fantasy.model.marca.FantasyRanking;
import com.nito.fantasy.model.marca.FantasyTeam;
import com.nito.fantasy.repositories.dynamodb.FantasyLeaguePlayerDBRepository;
import com.nito.fantasy.repositories.dynamodb.FantasyNewDBRepository;
import com.nito.fantasy.repositories.dynamodb.FantasyPlayerDBRepository;
import com.nito.fantasy.repositories.dynamodb.FantasyPlayerHistoryDBRepository;
import com.nito.fantasy.repositories.dynamodb.FantasyPlayerMarketDBRepository;
import com.nito.fantasy.util.Formatter;

@Service
public class FantasyService {
	private static final Logger logger = Logger.getLogger(FantasyService.class);

	private DynamoDBMapper dynamoDBMapper;

	@Autowired
	private AmazonDynamoDB amazonDynamoDB;

	@Autowired
	private FantasyLeaguePlayerDBRepository fantasyLeaguePlayerDBRepository;

	@Autowired
	private FantasyPlayerHistoryDBRepository fantasyPlayerHistoryDBRepository;

	@Autowired
	private FantasyNewDBRepository fantasyNewDBRepository;

	@Autowired
	private FantasyPlayerMarketDBRepository fantasyPlayerMarketDBRepository;

	@Autowired
	private FantasyPlayerDBRepository fantasyPlayerDBRepository;

	public List<FantasyLeague> getLeaguesFantasy(String authToken) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + authToken);

		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.laligafantasymarca.com/api/v4/leagues";
		logger.info(url);
		ResponseEntity<List<FantasyLeague>> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers),
				new ParameterizedTypeReference<List<FantasyLeague>>() {
				});
		List<FantasyLeague> fantasyLeagues = response.getBody();
		return fantasyLeagues;
	}

	public List<FantasyPlayer> getPlayers() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.laligafantasymarca.com/api/v3/players";
		logger.info(url);
		ResponseEntity<List<FantasyPlayer>> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers),
				new ParameterizedTypeReference<List<FantasyPlayer>>() {
				});
		List<FantasyPlayer> fantasyPlayers = response.getBody();
		return fantasyPlayers;
	}

	public FantasyPlayer getPlayer(String playerId) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.laligafantasymarca.com/api/v3/player/" + playerId;
		logger.info(url);
		ResponseEntity<FantasyPlayer> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers),
				new ParameterizedTypeReference<FantasyPlayer>() {
				});
		FantasyPlayer fantasyPlayer = response.getBody();
		return fantasyPlayer;
	}

	public List<FantasyRanking> getRankingFantasy(String authToken, String leagueId) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + authToken);

		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.laligafantasymarca.com/api/v4/leagues/" + leagueId + "/ranking";
		logger.info(url);
		ResponseEntity<List<FantasyRanking>> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers),
				new ParameterizedTypeReference<List<FantasyRanking>>() {
				});
		List<FantasyRanking> fantasyRanking = response.getBody();
		return fantasyRanking;
	}

	public List<FantasyMarket> getMarketFantasy(String authToken, String leagueId) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + authToken);

		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.laligafantasymarca.com/api/v3/league/" + leagueId + "/market";
		logger.info(url);
		ResponseEntity<List<FantasyMarket>> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers),
				new ParameterizedTypeReference<List<FantasyMarket>>() {
				});
		List<FantasyMarket> fantasyMarket = response.getBody();
		return fantasyMarket;
	}

	public FantasyTeam getTeamFantasy(String authToken, String leagueId, String teamId) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + authToken);

		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.laligafantasymarca.com/api/v3/leagues/" + leagueId + "/teams/" + teamId;
		logger.info(url);
		ResponseEntity<FantasyTeam> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers),
				new ParameterizedTypeReference<FantasyTeam>() {
				});
		FantasyTeam fantasyTeams = response.getBody();
		logger.info("fantasyTeams.getId():" + fantasyTeams.getId());
		return fantasyTeams;
	}

	public List<FantasyPlayerMarket> getPlayerMarketFantasy(String playerId) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.laligafantasymarca.com/api/v3/player/" + playerId + "/market-value";
		logger.info("url:" + url);
		ResponseEntity<List<FantasyPlayerMarket>> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers),
				new ParameterizedTypeReference<List<FantasyPlayerMarket>>() {
				});
		List<FantasyPlayerMarket> fantasyPlayerMarket = response.getBody();
		return fantasyPlayerMarket;
	}

	public List<FantasyHistory> getHistoryFantasy(String authToken, String league) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + authToken);

		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.laligafantasymarca.com/api/v3/league/" + league + "/market/history";
		logger.info(url);
		ResponseEntity<List<FantasyHistory>> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers),
				new ParameterizedTypeReference<List<FantasyHistory>>() {
				});
		List<FantasyHistory> fantasyHistory = response.getBody();
		return fantasyHistory;
	}

	public List<FantasyNew> getNewsFantasy(String authToken, String league, int newId) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + authToken);

		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.laligafantasymarca.com/api/v3/leagues/" + league + "/news/" + newId;
		logger.info(url);
		ResponseEntity<List<FantasyNew>> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers),
				new ParameterizedTypeReference<List<FantasyNew>>() {
				});
		List<FantasyNew> fantasyNews = response.getBody();
		return fantasyNews;
	}

	public List<Player> convertToDto(List<FantasyMarket> fantasyMarket) {
		List<Player> players = new ArrayList<Player>();
		for (FantasyMarket player : fantasyMarket) {
			if ("marketPlayerLeague".equals(player.getDiscr())) {
				FantasyPlayerDB playerDB = fantasyPlayerDBRepository.findById(player.getPlayerMaster().getId()).get();
				Player newPlayer = playerDB.convertToDto();
				newPlayer.setPlayerNumBids(player.getNumberOfBids());

				players.add(newPlayer);
			}
		}
		return players;
	}

	public List<Player> convertToDtoFromLeaguePlayersDB(List<FantasyPlayerDB> fantasyPlayersDB,
			List<FantasyLeaguePlayerDB> fantasyLeaguePlayersDB) {
		List<Player> players = new ArrayList<Player>();
		for (FantasyLeaguePlayerDB leaguePlayerDB : fantasyLeaguePlayersDB) {
			logger.info("leaguePlayerDB.getPlayerId():" + leaguePlayerDB.getPlayerId());
			Player newPlayer = new Player();
			FantasyPlayer fantasyPlayer = new FantasyPlayer();
			FantasyPlayerDB fantasyPlayerDB = new FantasyPlayerDB();
			try {
				// fantasyPlayerDB = fantasyPlayerDBRepository.findById(leaguePlayerDB.getPlayerId()).orElse(null);
				fantasyPlayerDB = fantasyPlayersDB.stream().filter(n -> n.getId().equals(leaguePlayerDB.getPlayerId())).findAny()
						.orElse(null);
			} catch (Exception e) {
				fantasyPlayerDB = null;
			}
			if (fantasyPlayerDB == null) {
				fantasyPlayer = getPlayer(leaguePlayerDB.getPlayerId());
				logger.error(
						"Player no encontrado en DB: " + fantasyPlayer.getNickname() + "(" + leaguePlayerDB.getPlayerId() + ")");
				fantasyPlayerDB = fantasyPlayer.convertToEntityDB();
				updateFantasyPlayerDB(fantasyPlayerDB, fantasyPlayer);
			}
			newPlayer = fantasyPlayerDB.convertToDto();
			newPlayer.setManagerName(Formatter.parseNull(leaguePlayerDB.getManagerName()));
			newPlayer.setTeamId(leaguePlayerDB.getTeamId());
			newPlayer.setPlayerBuyoutClause(leaguePlayerDB.getPlayerBuyoutClause());
			newPlayer.setPlayerEndBuyoutClause(leaguePlayerDB.getPlayerEndBuyoutClause());
			newPlayer.setUpDownBuyoutClause();
			newPlayer.setUpDownPurchaseDate(leaguePlayerDB.getPlayerPurchaseDate(), leaguePlayerDB.getPlayerPurchaseAmount(),
					leaguePlayerDB.getPlayerMarketValuePurchaseDate());
			players.add(newPlayer);
		}
		return players;
	}

	public List<Ranking> convertToDtoRanking(String league, List<FantasyRanking> fantasyRanking) {
		List<Ranking> ranking = new ArrayList<>();
		int initialBudget = 100000000;
		for (FantasyRanking obj : fantasyRanking) {
			Ranking newRanking = obj.convertToDto();
			List<FantasyNewDB> fantasyNewsDB = getFantasyNewsFromDB(league);
			Integer totalPurchases = fantasyNewsDB.stream()
					.filter(p -> obj.getTeam().getManager().getManagerName().equals(p.getManagerName()))
					.filter(p -> "purchase".equals(p.getOperation())).mapToInt(p -> p.getMoney()).sum();
			Integer totalSales = fantasyNewsDB.stream()
					.filter(p -> ("sale".equals(p.getOperation())
							&& obj.getTeam().getManager().getManagerName().equals(p.getManagerName()))
							|| ("purchase".equals(p.getOperation())
									&& obj.getTeam().getManager().getManagerName().equals(p.getPartnerName())))
					.mapToInt(p -> p.getMoney()).sum();
			Integer totalMoneyPoints = obj.getPoints() * 100000;
			Integer totalBalance = initialBudget + totalSales - totalPurchases + totalMoneyPoints;
			logger.info("ranking: " + newRanking.getPosition() + " - " + newRanking.getManagerName() + "(" + totalSales + "-"
					+ totalPurchases + "->" + totalBalance + ")");
			newRanking.setTeamMoneyAprox(totalBalance);
			Integer totalAvailable = (int) Math.round(((newRanking.getTeamValue() * new Double(0.2)) + totalBalance));
			newRanking.setTeamMoneyAvailable(totalAvailable);
			ranking.add(newRanking);
		}
		return ranking;
	}

	public void updateFantasyLeaguePlayersFromDB(String authToken, String leagueId) {

		clearFantasyLeaguePlayersFromDB(leagueId);
		List<FantasyLeaguePlayerDB> new_playersDB = new ArrayList<>();
		List<FantasyPlayerMarket> playerMarket = new ArrayList<>();
		List<FantasyNewDB> playersNewsDB = getFantasyNewsFromDB(leagueId);

		List<FantasyRanking> fantasyRanking = getRankingFantasy(authToken, leagueId);

		for (FantasyRanking rankingObj : fantasyRanking) {
			FantasyTeam team = getTeamFantasy(authToken, leagueId, rankingObj.getTeam().getId());
			for (com.nito.fantasy.model.marca.Player player : team.getPlayers()) {
				FantasyLeaguePlayerDB newPlayer = new FantasyLeaguePlayerDB();
				newPlayer.setLeagueId(leagueId);
				newPlayer.setPlayerId(player.getPlayerMaster().getId());
				newPlayer.setManagerName(team.getManager().getManagerName());
				newPlayer.setTeamId(team.getId());
				newPlayer.setPlayerBuyoutClause(player.getBuyoutClause());
				newPlayer.setPlayerEndBuyoutClause(player.getBuyoutClauseLockedEndTime());

				FantasyNewDB playerPurchase = playersNewsDB.stream().filter(p -> "purchase".equals(p.getOperation()))
						.filter(p -> player.getPlayerMaster().getNickname().equals(p.getPlayerName()))
						.filter(p -> leagueId.equals(p.getLeagueId())).filter(p -> p.getDate() != null)
						.sorted(Comparator.comparing(FantasyNewDB::getDate).reversed()).findFirst().orElse(null);
				if (playerPurchase != null) {
					newPlayer.setPlayerPurchaseDate(playerPurchase.getDate());
					newPlayer.setPlayerPurchaseAmount(playerPurchase.getMoney());
				}

				// playerMarket = getPlayerMarketFantasy(player.getPlayerMaster().getId());

				if (playerMarket != null && playerMarket.size() > 0) {

					if (playerPurchase != null) {
						Integer marketValuePurchaseDate = playerMarket.stream()
								.filter(p -> p.getDate().getYear() == playerPurchase.getDate().getYear()
										&& p.getDate().getDayOfYear() == playerPurchase.getDate().getDayOfYear())
								.findAny().orElse(null).getMarketValue();
						newPlayer.setPlayerMarketValuePurchaseDate(marketValuePurchaseDate);
					}
				}
				new_playersDB.add(newPlayer);
			}
		}
		fantasyLeaguePlayerDBRepository.saveAll(new_playersDB);
	}

	public void updatePlayersFromDB() {

		logger.info("updateAllPlayersFromDB");
		List<FantasyPlayerDB> playersDB = getFantasyPlayersFromDB();
		logger.info("playersDB - size:" + playersDB.size());
		List<FantasyPlayer> fantasyPlayers = getPlayers();
		List<FantasyPlayerDB> playersDB_new = new ArrayList<>();
		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

		int i = 0;
		int j = 0;
		for (FantasyPlayer obj : fantasyPlayers) {
			FantasyPlayer fantasyPlayer = getPlayer(obj.getId());
			FantasyPlayerDB objDB = null;
			if (playersDB != null && playersDB.size() > 0) {
				objDB = playersDB.stream().filter(p -> obj.getId().equals(p.getId())).findAny().orElse(null);
			}
			if (objDB == null) {
				objDB = fantasyPlayer.convertToEntityDB();
				i++;
				logger.info("save Player " + i + " - " + fantasyPlayer.getNickname());
				// fantasyPlayerDBRepository.save(objDB);
			}
			updateFantasyPlayerDB(objDB, fantasyPlayer);
			playersDB_new.add(objDB);
		}
		dynamoDBMapper.batchSave(playersDB_new);
		// fantasyPlayerDBRepository.saveAll(fantasyPlayersDB);
		logger.info("players saved");
		// dynamoDBMapper.batchSave(playersMarketDB_new);
		// fantasyPlayerMarketDBRepository.saveAll(fantasyPlayersMarketDB);
		// logger.info("market saved");
	}

	public void updateNewsFromDB(String authToken, String leagueId) {

		List<FantasyNewDB> newsDB = getFantasyNewsFromDB(leagueId);

		List<FantasyNew> fantasyNews = getNewsFantasy(authToken, leagueId, 1);

		for (FantasyNew obj : fantasyNews) {
			logger.info("Title:" + obj.getMsg());
			FantasyNewDB objDB = null;
			if ("Operación de mercado".equals(obj.getTitle())) {
				if (newsDB != null) {
					objDB = newsDB.stream().filter(p -> obj.getId().equals(p.getId())).findAny().orElse(null);
				}
				if (objDB == null) {
					objDB = obj.convertToEntityDB(leagueId);
					fantasyNewDBRepository.save(objDB);
				}
			}
		}
	}

	public void clearFantasyLeaguePlayersFromDB(String leagueId) {

		List<FantasyLeaguePlayerDB> players = new ArrayList<>();
		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
		CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(FantasyLeaguePlayerDB.class);
		tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
		TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);
		players = (List<FantasyLeaguePlayerDB>) fantasyLeaguePlayerDBRepository.findByLeagueId(leagueId);
		fantasyLeaguePlayerDBRepository.deleteAll(players);
	}

	public List<FantasyLeaguePlayerDB> getFantasyLeaguePlayersFromDB(String leagueId) {

		List<FantasyLeaguePlayerDB> players = new ArrayList<>();
		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
		CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(FantasyLeaguePlayerDB.class);
		tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
		TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);
		players = (List<FantasyLeaguePlayerDB>) fantasyLeaguePlayerDBRepository.findByLeagueId(leagueId);

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

	public List<FantasyPlayerDB> getFantasyPlayersFromDB() {

		List<FantasyPlayerDB> players = new ArrayList<>();
		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
		CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(FantasyPlayerDB.class);
		tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
		logger.info("FantasyPlayerDB - create table");
		TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);
		players = (List<FantasyPlayerDB>) fantasyPlayerDBRepository.findAll();
		logger.info("FantasyPlayerDB - findAll");

		return players;
	}

	public void clearFantasyPlayersFromDB() {

		List<FantasyPlayerDB> players = new ArrayList<>();
		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
		CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(FantasyPlayerDB.class);
		tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
		logger.info("FantasyPlayerDB - create table");
		TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);
		logger.info("FantasyPlayerDB - findAll");
		players = (List<FantasyPlayerDB>) fantasyPlayerDBRepository.findAll();
		logger.info("FantasyPlayerDB - deteleAll");
		dynamoDBMapper.batchDelete(players);
		// fantasyPlayerDBRepository.deleteAll();
	}

	public List<FantasyPlayerMarketDB> getFantasyPlayersMarketFromDB() {

		List<FantasyPlayerMarketDB> market = new ArrayList<>();
		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
		CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(FantasyPlayerMarketDB.class);
		tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
		TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);
		market = (List<FantasyPlayerMarketDB>) fantasyPlayerMarketDBRepository.findAll();

		return market;
	}

	public void clearFantasyPlayerMarketFromDB() {

		List<FantasyPlayerMarketDB> market = new ArrayList<>();
		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
		CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(FantasyPlayerMarketDB.class);
		tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
		logger.info("FantasyPlayerMarketDB - create table");
		TableUtils.createTableIfNotExists(amazonDynamoDB, tableRequest);
		logger.info("FantasyPlayerMarketDB - findAll");
		market = (List<FantasyPlayerMarketDB>) fantasyPlayerMarketDBRepository.findAll();
		logger.info("FantasyPlayerMarketDB - deteleAll");
		dynamoDBMapper.batchDelete(market);
		// fantasyPlayerMarketDBRepository.deleteAll();
	}

	public void updateFantasyPlayerDB(FantasyPlayerDB fantasyPlayerDB, FantasyPlayer fantasyPlayer) {
		Integer gamesPlayed = null;
		Integer gamesPlayed2 = null;
		Integer minutesPlayed = null;
		fantasyPlayerDB.setPlayerName(fantasyPlayer.getNickname());
		fantasyPlayerDB.setPlayerImage(fantasyPlayer.getImages().getTransparent().get64x64());
		fantasyPlayerDB.setPlayerPoints(fantasyPlayer.getPoints());
		fantasyPlayerDB.setPlayerAveragePoints(fantasyPlayer.getAveragePoints());
		fantasyPlayerDB.setPlayerPositionId(fantasyPlayer.getPositionId());
		fantasyPlayerDB.setPlayerTeamName(fantasyPlayer.getTeam().getName());
		fantasyPlayerDB.setPlayerTeamImage(fantasyPlayer.getTeam().getBadgeColor());
		fantasyPlayerDB.setPlayerMarketValue(fantasyPlayer.getMarketValue());
		if (fantasyPlayer.getPlayerStats() != null && fantasyPlayer.getPlayerStats().size() > 0) {
			gamesPlayed = fantasyPlayer.getPlayerStats().stream().filter(o -> o.getStats().getMinsPlayed().get(0) > 0)
					.mapToInt(o -> 1).sum();
			gamesPlayed2 = fantasyPlayer.getPlayerStats().stream().filter(o -> o.getStats().getMinsPlayed().get(0) > 40)
					.mapToInt(o -> 1).sum();
			minutesPlayed = fantasyPlayer.getPlayerStats().stream().filter(o -> o.getStats().getMinsPlayed().get(0) > 0)
					.mapToInt(o -> o.getStats().getMinsPlayed().get(0)).sum();
			fantasyPlayerDB.setPlayerGamesPlayed(gamesPlayed);
			fantasyPlayerDB.setPlayerGamesPlayed2(gamesPlayed2);
			fantasyPlayerDB.setPlayerMinutesPlayed(minutesPlayed);
		}

		List<FantasyPlayerMarket> playerMarket = getPlayerMarketFantasy(fantasyPlayer.getId());
		if (playerMarket != null && playerMarket.size() > 0) {
			fantasyPlayerDB.setPlayerMarketValue(playerMarket.get(playerMarket.size() - 1).getMarketValue());
			if (playerMarket.size() > 3) {
				fantasyPlayerDB.setPlayerMarketValueYesterday2(playerMarket.get(playerMarket.size() - 4).getMarketValue());
			}
			if (playerMarket.size() > 2) {
				fantasyPlayerDB.setPlayerMarketValueYesterday1(playerMarket.get(playerMarket.size() - 3).getMarketValue());
			}
			if (playerMarket.size() > 1) {
				fantasyPlayerDB.setPlayerMarketValueYesterday(playerMarket.get(playerMarket.size() - 2).getMarketValue());
			}
		}
	}
}
