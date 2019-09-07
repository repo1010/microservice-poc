package com.ms.productapp;

import java.util.Random;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;

//@EnableBinding(Source.class)
@EnableBinding(ChannelSource.class)
public class ProductInfoPublisher {

	// @InboundChannelAdapter(channel=Source.OUTPUT)
	@Bean
	//@InboundChannelAdapter(channel = "outchannel1", poller = @Poller(fixedDelay = "2000"))
	public MessageSource<Product> sendProdInfo() {
		Random r = new Random();
		int price = r.nextInt(5000);
		// return "{productName:\"Rice\",ProductCost:\"50\"}";
		return () -> MessageBuilder.withPayload(new Product("100","Fan", price)).setHeader("pricelevel", price).build();

	}

	class Product {

		public String productId;
		private String productName;
		private int productCost;

		
				
		public Product(String productId, String productName, int productCost) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.productCost = productCost;
		}

	}
}
