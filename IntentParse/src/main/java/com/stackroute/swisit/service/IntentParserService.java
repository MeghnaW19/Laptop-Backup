package com.stackroute.swisit.service;

import com.stackroute.swisit.domain.IndicatorOf;
import com.stackroute.swisit.domain.Intent;
import com.stackroute.swisit.domain.Relationships;
import com.stackroute.swisit.domain.Term;
import com.stackroute.swisit.neo4jresult.CounterIndicatorOf;
import org.neo4j.ogm.json.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IntentParserService {
    List<Intent> getAllIntents();
    List<Term> getAllTerms();
    Set<Term> getIndicatorTerms();
    Iterable<Map<String,Object>> getAllIndicator();
    Iterable<Map<String,Object>> getBothRelationships();
    Iterable<Map<String,Object>> getAllRelationships();
    List<Map<String,String>> fetchAllRelationships();
    Iterable<Map<String,String>> getAllTermsRelationOfIntent(String intentName);
}
