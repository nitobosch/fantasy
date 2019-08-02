package com.nito.fantasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nito.fantasy.entity.Player;
import com.nito.fantasy.entity.Ranking;
import com.nito.fantasy.model.FantasyRanking;
import com.nito.fantasy.model.FantasyTeam;
import com.nito.fantasy.service.FantasyService;
import org.apache.log4j.Logger;

@Controller
public class FantasyController {
	private static final Logger logger = Logger.getLogger(FantasyController.class);
	
    @Autowired
    private FantasyService fantasyService;
 
    public FantasyController(FantasyService fantasyService) {
        this.fantasyService = fantasyService;
    }
    
	@GetMapping("/")
    public String index() {
        return "home";
    }
    
    @RequestMapping(value = "/fantasyJson/ranking", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Ranking> fantasyRanking(@RequestParam(name="token", required=true) String token) {
        List<FantasyRanking> fantasyRanking = fantasyService.getRankingFantasy(token);
        return fantasyRanking.stream()
        		.map(n -> n.convertToDto())
        		.collect(Collectors.toList());
    }
    
    @RequestMapping(value = "/fantasyJson/players", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Player> fantasyPlayers(@RequestParam(name="token", required=true) String token, @RequestParam(name="teams", required=true) String teams, @RequestParam(name="diffValueBuyoutClause", required=false) Integer diff) {
    	logger.info("token:"+token);
    	logger.info("teams:"+teams);
    	logger.info("diff:"+diff);
    	List<String> teamsList = new ArrayList<String>(Arrays.asList(teams.split(",")));
    	List<FantasyTeam> fantasyTeams = new ArrayList<FantasyTeam>();
    	for (String teamId: teamsList) 
        { 
    		logger.info("teamId:"+teamId);
    		fantasyTeams.add(fantasyService.getTeamFantasy(token, teamId));
        } 
    	if(diff != null && !"null".equals(diff) && !"".equals(diff)) {
            return fantasyService.convertToDto(fantasyTeams)
    			  .stream()
    			  .filter(c -> c.getPlayerBuyoutClause() - c.getPlayerValue() < (diff*1000000))
    			  .collect(Collectors.toList());
    	}else {
            return fantasyService.convertToDto(fantasyTeams);
    	}
    }
    
}
