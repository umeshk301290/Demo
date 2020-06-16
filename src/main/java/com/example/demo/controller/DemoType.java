package com.example.demo.controller;

public enum DemoType  {
	
	AAKASH("AAKASH"),SAKSHI("SAKSHI");
	
	String name;
	DemoType(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
