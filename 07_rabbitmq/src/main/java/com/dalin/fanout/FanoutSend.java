package com.dalin.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSend {

	@Autowired
	private AmqpTemplate amqpTemplate; 
	
	public void send() {
		
		for (int i = 0; i < 10; i++) {
			String message = i+"----------:fanoutMessage";
			System.out.println("send$$$$$$$$$$$$$:" + message);
			this.amqpTemplate.convertAndSend("fExchange", "", message);
		}
		
	}
}
