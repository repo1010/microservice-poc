package com.ms.bootapp.repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.ms.bootapp.model.Product;

public class DbDataSource {

	public static List<Product> products = Arrays.asList(new Product("Milk",new BigDecimal(45.00),"Groceries"),
			new Product("Biscuit",new BigDecimal(10.50),"Groceries"),
			new Product("Shirt",new BigDecimal(300.00),"Cloth"),
			new Product("Bedsheet",new BigDecimal(105.00),"Cloth"),
			new Product("Cooker",new BigDecimal(650.00),"Utensiles"));
}
