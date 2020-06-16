package com.example.demo.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;


@Service()
public class parentbeandef {
	
	
	@Autowired
	beandef d;
	String name="rahul";
	
	@PostConstruct
	public void it() {
		d.setName(name);
		System.out.println("init method of parent is called");
	}
	public void getBean() {
		d = getBeanName();
	}
	private beandef getBeanName() {
		// TODO Auto-generated method stub
		beandef bf =this.getPrototype();
		return bf;
	}
	
	@Lookup
	beandef getPrototype() {
		
		return d;
	}
	
	
	
	


}
