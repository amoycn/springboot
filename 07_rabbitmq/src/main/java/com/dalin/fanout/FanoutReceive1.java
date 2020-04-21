package com.dalin.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceive1 {

	@RabbitHandler
	@RabbitListener(queues = "f.A")
	public void receive(String message) {
		System.out.println("A-------:"+message);
	}
}
