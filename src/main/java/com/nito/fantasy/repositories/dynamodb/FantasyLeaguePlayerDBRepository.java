package com.nito.fantasy.repositories.dynamodb;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.nito.fantasy.model.dynamodb.FantasyLeaguePlayerDB;

@EnableScan
public interface FantasyLeaguePlayerDBRepository extends CrudRepository<FantasyLeaguePlayerDB, String> {
    List<FantasyLeaguePlayerDB> findByLeagueId(String leagueId);
}
