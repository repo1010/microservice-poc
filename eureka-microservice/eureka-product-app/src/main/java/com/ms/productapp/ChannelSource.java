package com.ms.productapp;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;


public interface ChannelSource {

	@Output("outchannel1")
	MessageChannel outputChannel1();
	
	@Output("outchannel2")
	MessageChannel outputChannel2();
}
