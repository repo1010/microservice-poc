package com.ms.bootapp.model;

import java.math.BigDecimal;

public class Product {

	private String prodname;
	private BigDecimal prodcost;
	private String prodgroup;

	public Product() {

	}

	public Product(String prodname, BigDecimal prodcost, String prodgroup) {
		super();
		this.prodname = prodname;
		this.prodcost = prodcost;
		this.prodgroup = prodgroup;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public BigDecimal getProdcost() {
		return prodcost;
	}

	public void setProdcost(BigDecimal prodcost) {
		this.prodcost = prodcost;
	}

	public String getProdgroup() {
		return prodgroup;
	}

	public void setProdgroup(String prodgroup) {
		this.prodgroup = prodgroup;
	}

}
