package com.ms.cloudstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
//@EnableBinding(Processor.class)
@SpringBootApplication
public class CloudStreamAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamAppApplication.class, args);
	}

	@StreamListener(target=Sink.INPUT, condition="headers['pricelevel'] < 3000")
	//@ServiceActivator(inputChannel=Sink.INPUT)
	//@StreamListener(Processor.INPUT)
	//@SendTo(Processor.OUTPUT)
	public void receiveLowCostMsg(String msg) {

		System.out.println(msg + "is low price");
	//	return msg;
	}
	
	@StreamListener(target=Sink.INPUT, condition="headers['pricelevel'] >= 3000")
	//@ServiceActivator(inputChannel=Sink.INPUT)
	//@StreamListener(Processor.INPUT)
	//@SendTo(Processor.OUTPUT)
	public void receiveHighCostMsg(String msg) {

		System.out.println(msg + "is high price");
	//	return msg;
	}
}
