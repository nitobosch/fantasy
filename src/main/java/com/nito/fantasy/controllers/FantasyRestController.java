package com.nito.fantasy.controllers;

import java.util.Collections;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nito.fantasy.model.marca.FantasyRanking;

@RestController
public class FantasyRestController {
    
    @GetMapping("/fantasyJson")
    public List<FantasyRanking> fantasyJson(Model model) {
    	
        String authToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IkNBdXdPcWRMN2YyXzlhTVhZX3ZkbEcyVENXbVV4aklXV1MwNVB4WHljcUkifQ.eyJpc3MiOiJodHRwczovL2xvZ2luLmxhbGlnYS5lcy8zMzUzMTZlYi1mNjA2LTQzNjEtYmI4Ni0zNWE3ZWRjZGNlYzEvdjIuMC8iLCJleHAiOjE1NjQ3NzE3NDIsIm5iZiI6MTU2NDY4NTM0MiwiYXVkIjoiZmVjOWUzZmQtOGY4OC00NWFiLThjYmQtYjcwYjlkNjVkZGUwIiwiZW1haWwiOiJuaXRvLmJvc2NoQGdtYWlsLmNvbSIsImdpdmVuX25hbWUiOiJOaXRvIiwiZmFtaWx5X25hbWUiOiJCb3NjaCIsIm5hbWUiOiJHb29nbGUgdXNlciIsImlkcCI6Imdvb2dsZS5jb20iLCJzdWIiOiI4Njc3N2EzYi0xZGI0LTQ5OWMtYjNiZS02N2Y4NzAyYzIwOTYiLCJleHRlbnNpb25fRW1haWxWZXJpZmllZCI6dHJ1ZSwiZXh0ZW5zaW9uX1VzZXJQcm9maWxlSWQiOiI3YzIzOWE0Mi1jMWU2LTRiODMtYTA1Yi0wNWY4MDA5Mzk2MjMiLCJvaWQiOiI3YzIzOWE0Mi1jMWU2LTRiODMtYTA1Yi0wNWY4MDA5Mzk2MjMiLCJhenAiOiJmZWM5ZTNmZC04Zjg4LTQ1YWItOGNiZC1iNzBiOWQ2NWRkZTAiLCJ2ZXIiOiIxLjAiLCJpYXQiOjE1NjQ2ODUzNDJ9.UsmwCfATy566pvEUY0fh8bOiyUal75UTedSR2TwQTCh-nm4TX_O3U6SIbhyHZp63fe8o58DfqRNTzLNjBjXrdUNJH95QJILoi4AdP2aSAm8vzIeK4ETb5MUWjQz0rerhf2fDEoGAlRVF2-9NUsBZbkj6Ss_uZIJCb22mEVynSOswlxQWx7tZb5NAw9TGjyuuBOfwIIqhRxA6B5bxBPt_tNr_qikQjSJFfg3aHvL1pTnRf2XDDCG1Y3nJwxQADETb0yRT3h_EfMbDfrYu4jNEXlEYDoZreKnYofJbPsR9W6vHoE3eOyGni7-V_M_8TBpNJK_as5ipaahkcM1sYJh5eA";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));        
        headers.add("Authorization", "Bearer "+authToken );
        
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.laligafantasymarca.com/api/v4/leagues/0149334/ranking";
        ResponseEntity<List<FantasyRanking>> rankingResponse = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(headers), new ParameterizedTypeReference<List<FantasyRanking>>(){});
        List<FantasyRanking> fantasyRanking = rankingResponse.getBody();
        return fantasyRanking;
    }
    
}
