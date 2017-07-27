package com.stackroute.swisit.intentparse.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.swisit.intentparse.domain.ConfidenceBean;
import com.stackroute.swisit.intentparse.domain.CounterIndicatorTermWeight;
import com.stackroute.swisit.intentparse.domain.IndicatorTermWeight;
import com.stackroute.swisit.intentparse.domain.IntentBean;
import com.stackroute.swisit.intentparse.domain.IntentParser;
import com.stackroute.swisit.intentparse.domain.WordIntensity;
import com.stackroute.swisit.intentparse.repository.IntentRepository;
import com.stackroute.swisit.intentparse.repository.TermRepository;

@Service
public class CCalculatorServiceImpl implements CCalculatorService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	IntentRepository intentRepository;
	
	@Autowired
	TermRepository termRepository;
	
	@Override
	public ArrayList<ConfidenceBean> intentParserResult(IntentParser[] intentParserArr) {
        Iterable<IntentBean> intents=intentRepository.fetchAllIntents();
        ArrayList<ConfidenceBean> confidenceBeanArr=new ArrayList<>();
        for (IntentParser intentParser:intentParserArr) {
            confidenceBeanArr.addAll(calculateConfidence(intentParser,intents));
        }

        Collections.sort(confidenceBeanArr, new Comparator<ConfidenceBean>() {
            @Override
            public int compare(ConfidenceBean o1, ConfidenceBean o2) {
                return (int)(o2.getConfidenceScore()-o1.getConfidenceScore());
            }
        });
        return confidenceBeanArr;
    }
	@Override
	public ArrayList<ConfidenceBean> calculateConfidence(IntentParser intentParser,Iterable<IntentBean> intents) {
		ArrayList<ConfidenceBean> conbeanarr=null;
		for(IntentBean intent: intents){
			IndicatorTermWeight[] itw=termRepository.fetchIndicatorTerms();
			CounterIndicatorTermWeight[] citw=termRepository.fetchCounterIndicatorTerms();
			float in=0f,ci=0f;
			WordIntensity[] wordIntensity=intentParser.getWordIntensityList();
			for (WordIntensity mytermIntensity : wordIntensity) {
				for(IndicatorTermWeight indicatorTermWeight: itw){
					if(mytermIntensity.term.equalsIgnoreCase(indicatorTermWeight.getTermName()))
						in+=(mytermIntensity.intensity*indicatorTermWeight.getWeight());
				}
				for(CounterIndicatorTermWeight counterIndicatorTermWeight: citw){
					if(mytermIntensity.term.equalsIgnoreCase(counterIndicatorTermWeight.getTermName()))
						ci+=(mytermIntensity.intensity*counterIndicatorTermWeight.getWeight());
				}
			}
			final float confScore=in-ci;
			ConfidenceBean cbean=new ConfidenceBean(intent.getName(),confScore,intentParser.getUrl(),intentParser.getConcept());
			conbeanarr.add(cbean);
		}
		return conbeanarr;
	}
	
	
	@Override
	public void fetchIntentSpecificTerms(String intentName, String domainName) {
//		IndicatorTermWeight[]  i= fetchIndicatorTerms(String term) 
		
//		CounterIndicatorTermWeight[] c= fetchCounterIndicatorTerms(intentName, domainName);
		}
}
