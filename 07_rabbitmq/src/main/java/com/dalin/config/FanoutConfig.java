package com.dalin.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

	@Bean
	Queue aQueue() {
		return new Queue("f.A");
	}
	
	@Bean
	Queue bQueue() {
		return new Queue("f.B");
	}
	
	@Bean
	Queue cQueue() {
		return new Queue("f.C");
	}
		
	@Bean
	FanoutExchange fanoutExchange() {
		return new FanoutExchange("fExchange");
	}
	
	@Bean
	Binding aBindingExchange(FanoutExchange fanoutExchange , Queue aQueue) {
		return BindingBuilder.bind(aQueue).to(fanoutExchange);
	}
	
	@Bean
	Binding bBindingExchange(FanoutExchange fanoutExchange , Queue bQueue) {
		return BindingBuilder.bind(bQueue).to(fanoutExchange);
	}
	
	@Bean
	Binding cBindingExchange(FanoutExchange fanoutExchange , Queue cQueue) {
		return BindingBuilder.bind(cQueue).to(fanoutExchange);
	}	
	
}
