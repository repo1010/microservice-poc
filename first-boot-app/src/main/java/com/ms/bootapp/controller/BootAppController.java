package com.ms.bootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.bootapp.model.Product;
import com.ms.bootapp.repository.DbDataSource;

@RestController
public class BootAppController {


	@Value("${os.version}")
	private String osVersion;

	@RequestMapping(value = "/products")
	public ResponseEntity<List<Product>> getProduct() {
		System.out.println("osVersion " + osVersion);
		return ResponseEntity.ok().body(DbDataSource.products);
	}
}
