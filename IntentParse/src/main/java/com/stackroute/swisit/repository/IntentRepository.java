package com.stackroute.swisit.repository;

import com.stackroute.swisit.domain.IndicatorOf;
import com.stackroute.swisit.domain.Intent;
import com.stackroute.swisit.domain.Term;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
@Repository
public interface IntentRepository extends GraphRepository<Intent>{

    @Query("MATCH (n:`Intent`) RETURN n")
    List<Intent> findIntents();

    @Query("MATCH (t:Term)-[r:indicatorOf]->(i:Intent) where i.name=\"example\" RETURN t")
    Set<Term> getIndicatorTerms();

    @Query("CREATE (u:Document {url:{url}})")
    void createDocumentNode(@Param("url") String url);
}

