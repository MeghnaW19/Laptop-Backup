package com.stackroute.swisit.service;

import com.stackroute.swisit.domain.*;
import com.stackroute.swisit.exception.IntentParserExceptions;
import com.stackroute.swisit.repository.IntentRepository;
import com.stackroute.swisit.repository.RelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IntentParseAlgoImpl implements IntentParseAlgo {

    @Autowired
    IntentRepository intentRepository;

    @Autowired
    RelationshipRepository relationshipRepository;

    @Override
    public ArrayList<IntentParserResult> calculateConfidence(Iterable<CrawlerResult> intentInput){
        List<Intent> intentsList = intentRepository.findIntents();
        ArrayList<IntentParserResult> intentParserResultList = new ArrayList<IntentParserResult>();
        /*exception handling*/
        if(intentInput==null){
            throw new IntentParserExceptions("Invalid Input");
        }
        /*exception handling*/
        for(CrawlerResult intentParserInput : intentInput){
            intentParserResultList.addAll(calculateConfidenceScore(intentParserInput,intentsList));
        }
        Collections.sort(intentParserResultList, new Comparator<IntentParserResult>() {
            @Override
            public int compare(IntentParserResult o1, IntentParserResult o2) {
                return (int)(o2.getConfidenceScore()-o1.getConfidenceScore());
            }
        });
        return intentParserResultList;
    }

    @Override
    public ArrayList<IntentParserResult> calculateConfidenceScore(CrawlerResult intentParserInput,List<Intent> intentList){
        ArrayList<IntentParserResult> results=new ArrayList<IntentParserResult>();
        for (Intent intent : intentList) {
            List<Map<String, String>> relList = relationshipRepository.getAllTermsRelationOfIntent(intent.getName());
            /*exception handling*/
            if (relList == null) {
                throw new IntentParserExceptions("Empty data in database");
            }
            /*exception handling*/
            ContentSchema[] contentSchemas = intentParserInput.getTerms();
            ArrayList<Relationships> relationsList = new ArrayList<Relationships>();
            for (Map<String, String> map : relList) {
                Relationships r = new Relationships();
                r.setIntentName(map.get("intentName"));
                r.setTermName(map.get("termName"));
                r.setRelName(map.get("relName"));
                r.setWeight(Float.parseFloat(map.get("weight")));
                relationsList.add(r);
            }
            float in = 0f, ci = 0f, confidenceScore;
            for (ContentSchema contentSchema : contentSchemas) {
                for (Relationships relationships : relationsList) {
                    if (contentSchema.getWord() == null) { continue; }
                    if (contentSchema.getWord().equalsIgnoreCase(relationships.getTermName())) {
                        if (relationships.getRelName().equalsIgnoreCase("indicatorOf")) {
                            in += (contentSchema.getIntensity() * relationships.getWeight());
                        }
                        if (relationships.getRelName().equalsIgnoreCase("counterIndicatorOf")) {
                            ci += (contentSchema.getIntensity() * relationships.getWeight());
                        }
                    }
                }
            }
            confidenceScore = in - ci;
            IntentParserResult intentParserResult = new IntentParserResult(intentParserInput.getLink(), intent.getName(), confidenceScore, intentParserInput.getQuery());
            intentRepository.createDocumentNode(intentParserResult.getUrl());
            relationshipRepository.createDocToConceptRels(intentParserResult.getUrl(),intentParserResult.getIntent(),intentParserResult.getConfidenceScore(),intentParserResult.getConcept());
            results.add(intentParserResult);
        }
        return results;
    }
}
