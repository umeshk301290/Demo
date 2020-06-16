package com.example.demo.controller;

import org.springframework.context.ApplicationEvent;

public class customevent extends ApplicationEvent{

	String message;
	public customevent(Object source,String message) {
		super(source);
		// TODO Auto-generated constructor stub
		this.message = message;
	}

}
