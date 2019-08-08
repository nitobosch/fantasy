package com.nito.fantasy.repositories.dynamodb;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.nito.fantasy.model.dynamodb.FantasyPlayerHistoryDB;

@EnableScan
public interface FantasyPlayerHistoryDBRepository extends CrudRepository<FantasyPlayerHistoryDB, String> {
    List<FantasyPlayerHistoryDB> findByLeagueId(String leagueId);
}
