package com.stackroute.swisit.IntentParse.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class DummyJson {

	String nodeid;
	String intentName;
	String termName;
	String relationshipType;

	public String getNodeid() {
		return nodeid;
	}
	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
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
	public String getRelationshipType() {
		return relationshipType;
	}
	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}
	@Override
	public String toString() {
		return "DummyJson [nodeid=" + nodeid + ", intentName=" + intentName + ", termName=" + termName
				+ ", relationshipType=" + relationshipType + "]";
	}



}
