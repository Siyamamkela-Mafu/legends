package com.siyama.legends.repository;

import com.siyama.legends.domain.RequiredItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RequirementRepository extends MongoRepository <RequiredItem, String> {
        List<RequiredItem> findAllByEventId(String eventId);
        Boolean existsByNameContaining(String name);
}
