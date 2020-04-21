package com.dalin.fanout;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
public class FanoutReceive2 {

	@RabbitHandler
	@RabbitListener(queues = "f.B")
	public void receive(Message message , Channel channel) throws Exception {
		System.out.println("B-------:" + new String(message.getBody()));		
	}
}
