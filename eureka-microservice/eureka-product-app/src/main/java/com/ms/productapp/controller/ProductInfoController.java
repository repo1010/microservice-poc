package com.ms.productapp.controller;

import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ms.productapp.ChannelSource;

@RestController
public class ProductInfoController {

	@Autowired
	ChannelSource channelSource;
	
	@RequestMapping(value="publish", method=RequestMethod.POST)
	public String publishMessage(@RequestBody String payload) {
		System.out.println("Payload :" + payload);
		Random r  = new Random();
		int price = r.nextInt(5000);
		channelSource.outputChannel1().send(MessageBuilder.withPayload(payload).setHeader("pricelevel", price).build());
		
		return "success";
	}
}
