package com.dalin.topic;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
public class TopicReceive1 {

	@RabbitHandler
	@RabbitListener(queues = "msg1")
	public void receive(Message message , Channel channel) throws Exception {
		System.out.println("msg1--------" + new String(message.getBody()));
	} 
}
