package com.siyama.legends.repository;

import com.siyama.legends.domain.RequiredItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequirementRepository extends MongoRepository<RequiredItem, String> {
    List<RequiredItem> findAllByEventId(String eventId);
    boolean existsByNameContaining(String name);
}
