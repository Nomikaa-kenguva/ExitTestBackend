package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.entitys.Servicability;
import com.nagarro.repository.ServicabilityRepository;

@Component
public class ServicabilityService {
	
	@Autowired
	ServicabilityRepository serviceRepo;
	
	public List<Servicability> getEstimatedDays(int pincode) {
		List<Servicability> s =this.serviceRepo.findBypincodes(pincode);
		return s;
	}
}
