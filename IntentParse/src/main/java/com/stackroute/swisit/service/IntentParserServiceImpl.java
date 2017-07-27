package com.stackroute.swisit.service;

import com.stackroute.swisit.domain.Intent;
import com.stackroute.swisit.domain.Relationships;
import com.stackroute.swisit.domain.Term;
import com.stackroute.swisit.neo4jresult.CounterIndicatorOf;
import com.stackroute.swisit.repository.RelationshipRepository;
import com.stackroute.swisit.repository.IntentRepository;
import com.stackroute.swisit.repository.TermRepository;
import org.neo4j.ogm.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class IntentParserServiceImpl implements IntentParserService {

    @Autowired
    IntentRepository intentRepository;

    @Autowired
    TermRepository termRepository;

    @Autowired
    RelationshipRepository relationshipRepository;

    @Override
    public List<Intent> getAllIntents() {
        return intentRepository.findIntents();
    }

    @Override
    public List<Term> getAllTerms() {
        return termRepository.findTerms();
    }

    @Override
    public Set<Term> getIndicatorTerms() {
        return intentRepository.getIndicatorTerms();
    }

    @Override
    public Iterable<Map<String,Object>> getAllIndicator() {
        return relationshipRepository.getAllIndicator();
    }

    @Override
    public Iterable<Map<String, Object>> getBothRelationships() { return relationshipRepository.getBothRelationships(); }

    @Override
    public Iterable<Map<String,Object>> getAllRelationships() {
        return relationshipRepository.getAllRelationships();
    }

    @Override
    public List<Map<String,String>> fetchAllRelationships() {
        System.out.println(relationshipRepository.fetchAllRelationships().toString());
        return relationshipRepository.fetchAllRelationships();
    }

    @Override
    public Iterable<Map<String,String>> getAllTermsRelationOfIntent(String intentName) {
       // System.out.println(relationshipRepository.getAllTermsRelationOfIntent(intentName).toString());
        return relationshipRepository.getAllTermsRelationOfIntent(intentName);
    }

}
