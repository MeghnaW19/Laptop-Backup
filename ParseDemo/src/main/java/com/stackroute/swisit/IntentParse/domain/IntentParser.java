package com.stackroute.swisit.IntentParse.domain;

public class IntentParser {
	
	String url;
	String domain;
	String concept;
	WordIntensity[] wordIntensityList;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getConcept() {
		return concept;
	}
	public void setConcept(String concept) {
		this.concept = concept;
	}
	public WordIntensity[] getWordIntensityList() {
		return wordIntensityList;
	}
	public void setWordIntensityList(WordIntensity[] wordIntensityList) {
		this.wordIntensityList = wordIntensityList;
	}
	

}
