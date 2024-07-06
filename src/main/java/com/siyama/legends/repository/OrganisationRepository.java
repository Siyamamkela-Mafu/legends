package com.siyama.legends.repository;


import com.siyama.legends.domain.Organisation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepository extends MongoRepository<Organisation, String> {
    boolean existsByNameAndIsActiveTrue(String name);
}
