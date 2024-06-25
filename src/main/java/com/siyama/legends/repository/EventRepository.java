package com.siyama.legends.repository;


import com.siyama.legends.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EventRepository extends MongoRepository<Event, String> {

}
