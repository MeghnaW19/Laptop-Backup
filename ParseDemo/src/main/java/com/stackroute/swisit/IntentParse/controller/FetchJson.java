package com.stackroute.swisit.IntentParse.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.swisit.IntentParse.domain.DummyJson;

@Component
public class FetchJson {

	public Iterable<DummyJson> fetchJsn(){

		//create ObjectMapper instance
		List<DummyJson> list = new ArrayList<DummyJson>();
		ObjectMapper mapper = new ObjectMapper();
		File file	=	new File("src/main/resources/IntentTermRelation.json");

		DummyJson[] dummyJson;
		try {
			dummyJson = mapper.readValue(file, DummyJson[].class);
			for(DummyJson dummyJson1:dummyJson){
				list.add(dummyJson1);
			}			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	} 



}

