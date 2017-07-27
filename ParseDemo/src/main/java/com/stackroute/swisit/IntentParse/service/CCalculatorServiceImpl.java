package com.stackroute.swisit.IntentParse.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.stackroute.swisit.IntentParse.domain.IntentParser;

@Service
public class CCalculatorServiceImpl implements CCalculatorService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public float calculateConfidence(IntentParser intentParser) {

		logger.debug(intentParser.getDomain());
		logger.debug(intentParser.getConcept());
		logger.debug(intentParser.getUrl());
//		logger.debug(intentParser.getWordIntensityList());
		return 0;
	}




}
