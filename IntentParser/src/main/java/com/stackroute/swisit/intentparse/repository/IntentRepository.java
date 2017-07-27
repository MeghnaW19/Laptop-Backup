package com.stackroute.swisit.intentparse.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stackroute.swisit.intentparse.domain.IndicatorTermWeight;
import com.stackroute.swisit.intentparse.domain.IntentBean;

@RepositoryRestResource(collectionResourceRel = "intent", path = "intent")
public interface IntentRepository extends GraphRepository<String>{
		@Query("MATCH (i:Intent) Match (t:Term) Match (t)-[ir:IndicatorOf]->(i) Match (t)-[cir:CounterIndicatorOf]->(i) return i,t,ir,cir" )
	 	List<IntentBean> fetchAllIntents();
}
