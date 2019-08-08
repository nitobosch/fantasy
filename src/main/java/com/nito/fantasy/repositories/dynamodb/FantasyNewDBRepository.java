package com.nito.fantasy.repositories.dynamodb;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.nito.fantasy.model.dynamodb.FantasyNewDB;
import com.nito.fantasy.model.dynamodb.FantasyPlayerDB;

@EnableScan
public interface FantasyNewDBRepository extends CrudRepository<FantasyNewDB, String> {
    List<FantasyNewDB> findByLeagueId(String leagueId);
}
