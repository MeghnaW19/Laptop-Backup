package com.stackroute.swisit.repository;

import com.stackroute.swisit.domain.IndicatorOf;
import com.stackroute.swisit.domain.Relationships;
import com.stackroute.swisit.neo4jresult.CounterIndicatorOf;
import org.neo4j.ogm.json.JSONObject;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface RelationshipRepository extends GraphRepository<IndicatorOf> {

    @Query("MATCH ()-[r:indicatorOf]->() RETURN r")
    Iterable<Map<String,Object>> getAllIndicator();

    @Query("MATCH ()-[r:counterIndicatorOf]->() RETURN r")
    Iterable<Map<String,Object>> getAllCounterIndicator();

    @Query("MATCH ()-[r:IntentOf]->() RETURN r")
    Iterable<Map<String,Object>> getAllIntentOF();

    @Query("Match p=(t:Term)-[r]->(i:Intent) RETURN r")
    Iterable<Map<String,Object>> getBothRelationships();

    @Query("Match p=(t:Term)-[]->(i:Intent)-[]->(d:Intent) RETURN p")
    Iterable<Map<String,Object>> getAllRelationships();

    @Query("Match (t:Term)-[r]->(i:Intent) return t.name AS termName,i.name AS intentName,type(r) AS relName,r.weight AS weight")
    List<Map<String,String>> fetchAllRelationships();

    @Query("Match (t:Term)-[r]->(i:Intent {name: {0}}) return t.name AS termName,i.name AS intentName,type(r) AS relName,r.weight AS weight")
    List<Map<String,String>> getAllTermsRelationOfIntent(String intentName);
}
