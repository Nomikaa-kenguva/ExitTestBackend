package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entitys.Servicability;
import com.nagarro.service.ServicabilityService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ServicabilityController {
	
	
	private final ServicabilityService servicabilityService;
	
	@Autowired
	public ServicabilityController(ServicabilityService servicabilityService) {
		this.servicabilityService=servicabilityService;
	}
	
	@GetMapping("/check/{pincode}")
	public ResponseEntity<String> getEstimatedDaysByPincode(@PathVariable("pincode") int pincode) {
		List<Servicability> list = this.servicabilityService.getEstimatedDays(pincode);
		
		int a=0;
		if(list.size()!=0) {
			Servicability s=list.get(0);
			a=s.getEstimateddays();
		} 
	    if (a == 0) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Out of Service");
	    } else {
	        return ResponseEntity.status(HttpStatus.CREATED).body(String.valueOf(a));
	    }
	}
}
