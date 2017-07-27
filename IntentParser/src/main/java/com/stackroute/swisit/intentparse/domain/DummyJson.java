package com.stackroute.swisit.intentparse.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class DummyJson {

	String intentName;
	String termName;
	String relation;

	@JsonCreator
	public DummyJson(@JsonProperty("intentName")String intentname, @JsonProperty("relation")String relation,@JsonProperty("termName")String termname){
		this.termName=termname;
		this.intentName=intentName;
		this.relation=relation;
	}

	public String getIntentName() {
		return intentName;
	}

	public void setIntentName(String intentName) {
		this.intentName = intentName;
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
	}