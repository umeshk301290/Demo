package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class Customeventpublisher {
	
	@Autowired
	ApplicationEventPublisher eventPublisher;
	
	public void pubishEvent(String message) {
		
		customevent event = new customevent(this, message);
		eventPublisher.publishEvent(event);
		
	}

}
