package com.dalin.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HeaderConfig {

	@Bean
	Queue headerQueue() {
		return new Queue("headerY");
	}
	
	@Bean
	HeadersExchange headerExchange() {
		return new HeadersExchange("headerExchange");
	}
	
	@Bean
	Binding headerBindingExchange(Queue headerQueue, HeadersExchange headerExchange) {
		return BindingBuilder.bind(headerQueue).to(headerExchange).where("name").exists();
	}

	
}
