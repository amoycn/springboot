package com.dalin.header;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class HeaderSend {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send() {
		//这里x-match有两种类型
		//all:表示所有的键值对都匹配才能接受到消息
		//any:表示只要有键值对匹配就能接受到消息
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("x-match", "any");
		headers.put("name", "dalin");
		headers.put("age", "28");

		String content = headers.toString();
		MessageProperties mps = MessagePropertiesBuilder.newInstance()
				.setType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
				.setMessageId("123")
				.setHeader("name", "dalin")
				.build();
		
		Message message = MessageBuilder.withBody(content.getBytes())
				.andProperties(mps).build();
		this.amqpTemplate.convertAndSend("headerExchange", message);
		System.out.println("message:" + message);
	}
}
