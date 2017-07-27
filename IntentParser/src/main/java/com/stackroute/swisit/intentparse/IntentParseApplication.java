package com.stackroute.swisit.intentparse;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.stackroute.swisit.intentparse.controller.FetchJson;

import org.springframework.context.ApplicationContext;


@EnableNeo4jRepositories
@SpringBootApplication
public class IntentParseApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(IntentParseApplication.class, args);
		FetchJson fj = ctx.getBean(FetchJson.class, args);
		try {
			System.out.println(fj.fetchJsn());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
