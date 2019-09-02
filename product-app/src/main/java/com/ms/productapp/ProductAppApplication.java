package com.ms.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RequestMapping("/prod")
public class ProductAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductAppApplication.class, args);
	}

	@Bean
	 RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	public RestTemplate restTemplate;
	
	@RequestMapping(value="/{prodid}", method= RequestMethod.GET)
	public String getProdInfo(@PathVariable Integer prodid) {
		
		ResponseEntity<String> nameresponse = restTemplate.getForEntity("http://localhost:8091/prodname/"+prodid, String.class);
		ResponseEntity<Double> costresponse = restTemplate.getForEntity("http://localhost:8092/prodcost/"+prodid, Double.class);
		
		return nameresponse.getBody() + "    "+costresponse.getBody();
		
	}
}
