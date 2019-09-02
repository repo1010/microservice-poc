package com.vishal.cloud.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vishal.cloud.hystrix.service.HystrixService;

@RestController
@RequestMapping("hystrix")
public class HystrixController {

	@Autowired
	HystrixService hystrixService;

	@RequestMapping("/getdetails")
	public ResponseEntity<String> getDetaiils() {
		return hystrixService.getDetails();
	}
}
