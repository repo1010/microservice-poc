package com.ms.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@Controller
public class ProductController {

	@Value("${prod.name}")
	private String prodName;

	@Value("${prod.cost}")
	private String prodCost;
	
	@Value("${connstring}")
	private String connstring;

	@RequestMapping(value = "/prodinfo", method = RequestMethod.GET)
	public String getProdInfo(Model model) {

		System.out.println("prodName :"+ prodName + " prodCost : "+ prodCost);
		model.addAttribute("prodName", prodName);
		model.addAttribute("prodCost", prodCost);
		model.addAttribute("connstring", connstring);

		return "prodinfo";

	}
}
