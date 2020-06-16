package com.example.demo.controller;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class customelistner implements ApplicationListener<customevent> {

	@Override
	public void onApplicationEvent(customevent event) {
		// TODO Auto-generated method stub
		System.out.println("recieved message" + event.message);
	}

}
