package com.vishal.cloud.hystrix.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HystrixServiceImpl implements HystrixService{

	@Autowired
	RestTemplate restTemplate;
	
	private ResponseEntity<String> exchange;
	
	@HystrixCommand(fallbackMethod="fallbackCallForGetDetails")
	public ResponseEntity<String> getDetails() {
		try {
			URI endpoint = URI.create("http://localhost:8897/getdetails");
			exchange = restTemplate.getForEntity(endpoint, String.class);
			
		} catch (RuntimeException e) {
			throw e;
		}

		return exchange;
	}
	
	
	public ResponseEntity<String> fallbackCallForGetDetails() {
		try {
			URI endpoint = URI.create("http://localhost:8898/getdetails");
			exchange = restTemplate.getForEntity(endpoint, String.class);
		} catch (RuntimeException e) {
			throw e;
		}

		return exchange;
	}
}
