package com.stackroute.swisit.intentparse.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stackroute.swisit.intentparse.domain.CounterIndicatorTermWeight;
import com.stackroute.swisit.intentparse.domain.IndicatorTermWeight;
import com.stackroute.swisit.intentparse.domain.IntentParser;

@RepositoryRestResource(collectionResourceRel = "term", path = "term")
public interface TermRepository  extends GraphRepository<IndicatorTermWeight>{
	@Query("MATCH (i:Intent {name:{intentName}})" +
		"MATCH (t:Term)" +
		"MATCH (d:Domain {name:{domainName})" +
			"MATCH (d)<-[r1:IntentOf]-(i)" +
		    "MATCH (i)<-[r:IndicatorOf]-(t) return t.name, r.weight" )
	IndicatorTermWeight[] fetchIndicatorTerms();
	
	@Query("MATCH (i:Intent {name:{intentName}})" +
			"MATCH (t:Term)" +
			"MATCH (d:Domain {name:{domainName})" +
			"MATCH (d)<-[r1:intentOf]-(i)" +
			"MATCH (i)<-[r:counterIndicatorOf]-(t) return t.name, r.weight") 	
	CounterIndicatorTermWeight[] fetchCounterIndicatorTerms();
	 
}
