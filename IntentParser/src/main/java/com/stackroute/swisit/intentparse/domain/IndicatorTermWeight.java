package com.stackroute.swisit.intentparse.domain;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class IndicatorTermWeight {
	String intent;
	String termName;
	float weight;
	public IndicatorTermWeight(String intent, String termName, float weight) {
		super();
		this.intent = intent;
		this.termName = termName;
		this.weight = weight;
	}
	public IndicatorTermWeight() {}
	public String getIntent() {
		return intent;
	}
	public void setIntent(String intent) {
		this.intent = intent;
	}
	public String getTermName() {
		return termName;
	}
	public void setTermName(String termName) {
		this.termName = termName;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}	
}


