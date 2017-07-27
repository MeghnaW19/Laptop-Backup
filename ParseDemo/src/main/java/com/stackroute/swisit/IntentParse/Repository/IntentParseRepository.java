package com.stackroute.swisit.IntentParse.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.swisit.IntentParse.domain.IntentParser;

public interface IntentParseRepository extends MongoRepository<IntentParser, String> {

}
