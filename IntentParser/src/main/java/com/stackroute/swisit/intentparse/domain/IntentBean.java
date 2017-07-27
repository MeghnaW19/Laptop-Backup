package com.stackroute.swisit.intentparse.domain;

public class IntentBean {
	
	String name;
	String nodeid;
	public IntentBean() {}
	public IntentBean(String name, String nodeid) {
		super();
		this.name = name;
		this.nodeid = nodeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNodeid() {
		return nodeid;
	}
	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}
	
}
