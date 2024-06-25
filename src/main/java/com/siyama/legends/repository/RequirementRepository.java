package com.siyama.legends.repository;

import com.siyama.legends.domain.RequiredItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RequirementRepository extends MongoRepository <RequiredItem, String> {

}
