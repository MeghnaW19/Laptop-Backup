package com.stackroute.swisit.intentparse.domain;

public class ConfidenceBean {
	
	String intent;
	float confidenceScore;
	String url;
	String concept;
	
	public ConfidenceBean(){}
	
	public ConfidenceBean(String intent, float confidenceScore, String url, String concept) {
		super();
		this.intent = intent;
		this.confidenceScore = confidenceScore;
		this.url = url;
		this.concept = concept;
	}
	
	public String getIntent() {
		return intent;
	}
	
	public void setIntent(String intent) {
		this.intent = intent;
	}
	
	public float getConfidenceScore() {
		return confidenceScore;
	}
	
	public void setConfidenceScore(float confidenceScore) {
		this.confidenceScore = confidenceScore;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getConcept() {
		return concept;
	}
	
	public void setConcept(String concept) {
		this.concept = concept;
	}
}
