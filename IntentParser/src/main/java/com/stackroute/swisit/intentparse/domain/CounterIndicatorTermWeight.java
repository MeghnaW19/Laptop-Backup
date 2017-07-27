package com.stackroute.swisit.intentparse.domain;

import java.util.List;

import org.springframework.data.annotation.*;
import org.neo4j.graphdb.Direction;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.annotation.TypeAlias;


@NodeEntity
public class CounterIndicatorTermWeight {
	String intent;
	String termName;
	float weight;
	public CounterIndicatorTermWeight() {
		super();
	}
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
	public CounterIndicatorTermWeight(String intent, String termName, float weight) {
		super();
		this.intent = intent;
		this.termName = termName;
		this.weight = weight;
	}
}