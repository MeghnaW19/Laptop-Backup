package com.stackroute.swisit.IntentParse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.stackroute.swisit.IntentParse.controller.FetchJson;

@SpringBootApplication
public class IntentParseApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(IntentParseApplication.class, args);
		FetchJson fj = ctx.getBean(FetchJson.class, args);
		System.out.println(fj.fetchJsn());
	}
}
