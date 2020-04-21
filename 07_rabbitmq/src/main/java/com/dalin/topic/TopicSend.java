package com.dalin.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSend {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send() {
		this.amqpTemplate.convertAndSend("tExchange", "msg.one", "msg.one");
		this.amqpTemplate.convertAndSend("tExchange", "msg.eee", "msg.eee");
		this.amqpTemplate.convertAndSend("tExchange", "msg.ddd", "msg.ddd");
	}
}
