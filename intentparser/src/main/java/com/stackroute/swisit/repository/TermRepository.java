package com.stackroute.swisit.repository;

import com.stackroute.swisit.domain.Term;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TermRepository extends GraphRepository<Term> {
    @org.springframework.data.neo4j.annotation.Query("MATCH (n:`Term`) RETURN n")
    List<Term> findTerms();
}
