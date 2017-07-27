package com.stackroute.swisit.intentparse.service;

import java.util.ArrayList;

import com.stackroute.swisit.intentparse.domain.ConfidenceBean;
import com.stackroute.swisit.intentparse.domain.IntentBean;
import com.stackroute.swisit.intentparse.domain.IntentParser;

public interface CCalculatorService {
	
	ArrayList<ConfidenceBean> intentParserResult(IntentParser[] intentParserArr);
	ArrayList<ConfidenceBean> calculateConfidence(IntentParser intentParser,Iterable<IntentBean> intents);
	void fetchIntentSpecificTerms(String intentName, String domainName);
}
