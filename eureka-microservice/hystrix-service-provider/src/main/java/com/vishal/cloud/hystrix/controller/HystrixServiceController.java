package com.vishal.cloud.hystrix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixServiceController {

	@RequestMapping("/getdetails")
	public Object getDetails(){
		
		return ResponseEntity.status(200).body("Hello From HystrixServiveProvider");
	}
}
