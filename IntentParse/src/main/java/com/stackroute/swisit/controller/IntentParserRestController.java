package com.stackroute.swisit.controller;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.swisit.assembler.HeteoasLinkAssembler;
import com.stackroute.swisit.domain.*;
import com.stackroute.swisit.exception.IntentParserExceptions;
import com.stackroute.swisit.service.IntentParseAlgo;
import com.stackroute.swisit.service.IntentParserService;
import com.stackroute.swisit.subscriber.SubscriberImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.neo4j.ogm.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value="/v1/api/parse/")
@Api(value="SWIS-it", description="Operations pertaining to the IntentParserService")

public class IntentParserRestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IntentParserService intentParserService;

    @Autowired
    IntentParseAlgo intentParseAlgo;
    
    @Autowired
    HeteoasLinkAssembler heteoasLinkAssembler;

    @Autowired
    SubscriberImpl subscriberImpl;
    
    @Autowired
	private MessageSource messageSource;

    
    @ApiOperation(value="CrawlerValue",response = CrawlerResult.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved Crawler"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
			)
    
    @RequestMapping(value="subscriber" , method=RequestMethod.GET)
    public ResponseEntity<Iterable> demo(){
        Iterable<CrawlerResult> l=subscriberImpl.receivingMessage("tointent");
       // CrawlerResult cr[]=new CrawlerResult[l.size()];
        //l.toArray(cr);
        for(CrawlerResult lr:l){
            System.out.println("link is "+lr.getLink());
            System.out.println("query is "+lr.getQuery());
            System.out.println("snippet is "+lr.getSnippet());
            System.out.println("title is  "+lr.getTitle());
            System.out.println("date is "+lr.getLastindexedof());
           // System.out.println("terms is "+lr.getTerms());

        }
        //System.out.println("list is "+l);
        return new ResponseEntity<Iterable>(l, HttpStatus.OK);
    }

    @ApiOperation(value="CrawlerValue",response = CrawlerResult.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved Crawler"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
			)
    @RequestMapping(value = "/fetch", method= RequestMethod.POST)
    public ResponseEntity<Iterable> fetchNeoData(){

        List<Intent> intentsList = intentParserService.getAllIntents();
        List<Term> termsList = intentParserService.getAllTerms();
        Set<Term> indicatorTerms = intentParserService.getIndicatorTerms();
        Iterable<Map<String,Object>> indicatorOfs = intentParserService.getAllIndicator();
       // System.out.println(indicatorOfs);
        Iterable<Map<String,Object>> bothRelationships = intentParserService.getBothRelationships();
        Iterable<Map<String,Object>> allRelationships = intentParserService.getAllRelationships();
        List<Map<String,String>> fetchallRelationships = intentParserService.fetchAllRelationships();
        //System.out.println(fetchallRelationships);
        Iterable<Map<String,String>> getAllIntentRelationships = intentParserService.getAllTermsRelationOfIntent("example");
        return new ResponseEntity<Iterable>(getAllIntentRelationships, HttpStatus.OK);
    }

    @ApiOperation(value="Calculate Confidence Score",response = CrawlerResult.class)
   	@ApiResponses(value = {
   			@ApiResponse(code = 200, message = "Successfully retrieved Crawler"),
   			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
   			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
   			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
   	}
   			)
    @RequestMapping(value = "", method= RequestMethod.POST)
    public ResponseEntity<List> calculateConfidenceScore() throws JsonParseException, JsonMappingException, IOException{
       
		Locale locale = LocaleContextHolder.getLocale();
		List<IntentParserResult> result=null;
        try{
            Iterable<CrawlerResult> intentInput=subscriberImpl.receivingMessage("tointent");
            if(intentInput==null){
        		String message = messageSource.getMessage ("user.excep.data", null, locale );
                return new ResponseEntity(message,HttpStatus.OK);
            }
          for(CrawlerResult lr:intentInput){
             System.out.println("link is "+lr.getLink());
             System.out.println("query is "+lr.getQuery());
             System.out.println("content schema is "+lr.getTerms()[0].getWord()+"---"+lr.getTerms()[0].getIntensity());
             System.out.println("snippet is "+lr.getSnippet());
             System.out.println("title is  "+lr.getTitle());
             System.out.println("date is "+lr.getLastindexedof());
         }
             
             result=(List<IntentParserResult>)intentParseAlgo.calculateConfidence(intentInput);
             List<IntentParserResult> ConfResult=heteoasLinkAssembler.calculateConfidence(result);
        Iterable<Map<String,String>> fetchallRelationships = intentParserService.fetchAllRelationships();
        return new ResponseEntity<List>(ConfResult, HttpStatus.OK);
        }
        catch (IntentParserExceptions e){
            System.out.println(e);
        }
        return new ResponseEntity<List>(result, HttpStatus.OK);
    }
}
