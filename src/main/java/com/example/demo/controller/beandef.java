package com.example.demo.controller;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class beandef implements beaninterface {
	
	String name;
	beandef(){
		System.out.println("beandef constructor called");
		//this.name=name;
	}
	@PostConstruct
	public void init() {
		System.out.println("beandef init called");

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
