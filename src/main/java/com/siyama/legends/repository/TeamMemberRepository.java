package com.siyama.legends.repository;


import com.siyama.legends.domain.TeamMember;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends MongoRepository<TeamMember, String> {

    boolean existsByNameAndSurnameAndIsActiveTrue(String name, String surname);

}
