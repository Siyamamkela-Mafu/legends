package com.siyama.legends.repository;


import com.siyama.legends.domain.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<Team, String> {

    boolean existsByNameAndIsActiveTrue(String name);

}
