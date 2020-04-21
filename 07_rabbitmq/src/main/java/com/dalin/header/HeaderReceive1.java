package com.dalin.header;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
public class HeaderReceive1 {

	@RabbitHandler
	@RabbitListener(queues = "headerY")
	public void receive(Message message , Channel channel) throws Exception {
		System.out.println("header--------" + new String(message.getBody()));
	} 
}
