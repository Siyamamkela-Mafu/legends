package com.siyama.legends.repository;


import com.siyama.legends.domain.TeamMember;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TeamMemberRepository extends MongoRepository<TeamMember, String> {

    boolean existsByNameAndSurnameAndIsActiveTrue(String name, String surname);
    List<TeamMember> findAllByIdIn(Collection<String> ids);

}
