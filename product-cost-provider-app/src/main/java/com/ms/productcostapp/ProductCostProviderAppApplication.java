package com.ms.productcostapp;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/prodcost")
public class ProductCostProviderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCostProviderAppApplication.class, args);
	}

private Map<Integer,Double> prodcosts = new HashMap();
	
	@RequestMapping(value="/{prodid}" , method = RequestMethod.GET)
	public Double getProdName(@PathVariable Integer prodid) {
		
		prodcosts.put(100, 120.80);
		prodcosts.put(200, 230.50);
		prodcosts.put(300, 560.40);
		
		System.out.println(prodid + "   " +prodcosts.get(prodid));
		return prodcosts.get(prodid);
	}
}
