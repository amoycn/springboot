package com.dalin.simple;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSend {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;	
	private final static String QUEUES = "Hello";
	
	public void send1() {
		
		Long times = System.currentTimeMillis();
		String message = "1:*************************Hello World!   Now:" + times;
		
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(300);
				//System.out.println(i + ":" + message);
				this.rabbitTemplate.convertAndSend(QUEUES, "发送者:" + i + "--" + message);				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public void send2() {
		
		Long times = System.currentTimeMillis();
		String message = "2:-------------------------Hello World!   Now:" + times;
		
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(360);
				System.out.println(i + ":" + message);
				this.rabbitTemplate.convertAndSend(QUEUES, i + ":*********" + message);				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}

}
