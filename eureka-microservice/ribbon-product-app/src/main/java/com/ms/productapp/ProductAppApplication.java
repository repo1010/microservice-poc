package com.ms.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
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
@EnableDiscoveryClient
//@RibbonClient(name="product-cost-provider")
public class ProductAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductAppApplication.class, args);
	}

	
	@LoadBalanced
	@Bean
	 RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Autowired
	public RestTemplate restTemplate;
	
	@RequestMapping(value="/{prodid}", method= RequestMethod.GET)
	public String getProdInfo(@PathVariable Integer prodid) {
		
		System.out.println("getProdInfo");
		//ResponseEntity<String> nameresponse = restTemplate.getForEntity("http://product-name-provider/prodname/"+prodid, String.class);
		ResponseEntity<Double> costresponse = restTemplate.getForEntity("http://product-cost-provider/prodcost/"+prodid, Double.class);
		
		return /* nameresponse.getBody() + "    "+ */costresponse.getBody().toString();
		
	}
}
