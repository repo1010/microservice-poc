package com.vishal.cloud.hystrix.service;

import org.springframework.http.ResponseEntity;

public interface HystrixService {

	public ResponseEntity<String> getDetails();
}
