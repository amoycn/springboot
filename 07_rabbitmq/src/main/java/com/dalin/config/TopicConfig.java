package com.dalin.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TopicConfig {

	@Bean
	Queue msg1Queue() {
		return new Queue("msg1");
	}
	
	@Bean
	Queue msg2Queue() {
		return new Queue("msg2");
	}
	
	@Bean
	TopicExchange tExchange() {
		return new TopicExchange("tExchange");
	}
	
	@Bean
	Binding bindingExchange1(Queue msg1Queue, TopicExchange tExchange) {
		return BindingBuilder.bind(msg1Queue).to(tExchange).with("msg.one");
	}
	
	@Bean
	Binding bindingExchange2(Queue msg2Queue, TopicExchange tExchange) {
		return BindingBuilder.bind(msg2Queue).to(tExchange).with("msg.#");
	}
	
}
