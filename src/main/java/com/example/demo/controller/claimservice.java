package com.example.demo.controller;

import org.springframework.stereotype.Service;

@Service

public class claimservice {
	
	
public claim createClaim() {
	claim c = new claim();
	c.setClaimId(2);
	c.setVendorname("java");
	c.setVendornumber("123");
	return c;
	
}	

public claim getClaim() {
	claim c = new claim();
	c.setClaimId(1);
	c.setVendorname("c++");
	c.setVendornumber("345");
	return c;
	
}

}
