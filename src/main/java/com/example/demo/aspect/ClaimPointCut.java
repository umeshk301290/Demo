package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class ClaimPointCut {

	@Pointcut(value = "execution(* com.example.demo.controller.claimservice.createClaim(..))")
	public void callAfterSaveClaim() {
	
	}
}
