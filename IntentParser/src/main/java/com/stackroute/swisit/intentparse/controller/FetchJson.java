package com.stackroute.swisit.intentparse.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FetchJson {

	public List<String> fetchJsn() throws JsonParseException, JsonMappingException, IOException{

		//create ObjectMapper instance
		ObjectMapper mapper = new ObjectMapper();
		File file	=	new File("src/main/resources/IntentTermRelation.json");
		List<LinkedHashMap<String,String>> list = (List<LinkedHashMap<String, String>>) mapper.readValue(file, ArrayList.class);


		List<String> result = new ArrayList<String>();

		for(int i=0;i<list.size();i++){
			LinkedHashMap<String, String> hashMap = list.get(i);
			result.add(hashMap.get("termname"));
			result.add(hashMap.get("weight"));
			result.add(hashMap.get("intentname"));
			result.add(hashMap.get("relation"));
		}
		return result;

	}

	}
