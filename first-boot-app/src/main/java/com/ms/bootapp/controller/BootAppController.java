package com.ms.bootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.bootapp.model.Product;
import com.ms.bootapp.repository.DbDataSource;

@RestController
@RequestMapping("/")
public class BootAppController {

	private DbDataSource dbDataSource;
	
	@Value("${os.version}")
	private String osVersion;
	
	@RequestMapping(value= "/products")
	public List<Product> getProduct(){
		System.out.println("osVersion " + osVersion);
		return DbDataSource.products;
	}
}
