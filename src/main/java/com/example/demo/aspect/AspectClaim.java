package com.example.demo.aspect;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.controller.Address;
import com.example.demo.controller.AddressRepository;
import com.example.demo.controller.ClientData;
import com.example.demo.controller.ClientDataRepository;
import com.example.demo.controller.claim;


@Component
@Aspect
public class AspectClaim {
	
	@Autowired
	AddressRepository addressRepo;
	@Autowired
	ClientDataRepository clientDataRepo;
	
	@AfterReturning(pointcut = "com.example.demo.aspect.ClaimPointCut.callAfterSaveClaim()", returning = "c")
	public void notifyAfterClaimSave(claim c){
		Address address = new Address ();
		address.setDistric("mumbai");
		address.setPostcode("20301");
		//addressRepo.save(address);
		List<Address> addressList = new ArrayList();
		addressList.add(address);
		ClientData cd = new ClientData();
		cd.setClientName(c.getVendorname());
		cd.setAddress(addressList);
		Optional<ClientData> op = clientDataRepo.findById(2L);
		ClientData data = op.get();
		clientDataRepo.save(cd);
		addressRepo.save(address);

		
		System.out.println("Notification generated at create adhoc claim");
		
	}	
	

}
