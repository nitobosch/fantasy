package com.nito.fantasy.repositories.dynamodb;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.nito.fantasy.model.dynamodb.FantasyNewDB;
import com.nito.fantasy.model.dynamodb.FantasyLeaguePlayerDB;
import com.nito.fantasy.model.dynamodb.FantasyPlayerMarketDB;

@EnableScan
public interface FantasyPlayerMarketDBRepository extends CrudRepository<FantasyPlayerMarketDB, String> {
    List<FantasyPlayerMarketDB> findByPlayerId(String playerId);
}
