package com.dalin.fanout;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;


@Component
public class FanoutReceive3 {

	@RabbitHandler
	@RabbitListener(queues = "f.C")
	public void receive(Message message , Channel channel) throws Exception {
		System.out.println("C-------:" + new String(message.getBody()));
		//消息确认，并移除Queue数据
		//false只确认当前一个消息收到，true确认所有consumer获得的消息 ?? 怎么理解？
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
	}
}
