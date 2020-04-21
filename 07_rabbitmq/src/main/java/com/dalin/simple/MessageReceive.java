package com.dalin.simple;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
public class MessageReceive {

	@RabbitHandler
	@RabbitListener(queues = "Hello")
	public void receive(Message message , Channel channel) throws Exception {
		Thread.sleep(666);
		System.out.println("接收者1:" + new String(message.getBody()));
		//拒绝消息
		// true 发送给下一个消费者
		// false 谁都不接受，从队列中删除
//		channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
	} 
}
