package com.stackroute.swisit.service;

import com.stackroute.swisit.domain.Intent;
import com.stackroute.swisit.domain.CrawlerResult;
import com.stackroute.swisit.domain.IntentParserResult;
import com.stackroute.swisit.exception.IntentParserExceptions;

import java.util.ArrayList;
import java.util.List;

public interface IntentParseAlgo {

    public List<IntentParserResult> calculateConfidence(Iterable<CrawlerResult> intentInput);
    public ArrayList<IntentParserResult> calculateConfidenceScore(CrawlerResult intentParserInput, List<Intent> intentList);
}
