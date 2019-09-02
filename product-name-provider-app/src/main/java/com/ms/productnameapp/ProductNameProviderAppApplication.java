package com.ms.productnameapp;

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
@RequestMapping("/prodname")
public class ProductNameProviderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductNameProviderAppApplication.class, args);
	}

	private Map<Integer,String> prodnames = new HashMap();
	
	@RequestMapping(value="/{prodid}", method=RequestMethod.GET)
	public String getProdName(@PathVariable Integer prodid) {
		
		prodnames.put(100, "Milk");
		prodnames.put(200, "Butter");
		prodnames.put(300, "Ghee");
		
		System.out.println(prodid + "   " +prodnames.get(prodid));
		return prodnames.get(prodid);
	}
}
