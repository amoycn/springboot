package com.dalin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalin.fanout.FanoutSend;
import com.dalin.header.HeaderSend;
import com.dalin.simple.MessageSend;
import com.dalin.topic.TopicSend;

@RestController
public class TestController {
	
	@Autowired
	private MessageSend sender;
	@Autowired
	private FanoutSend fanoutSender;
	@Autowired
	private TopicSend topicSender;
	@Autowired
	private HeaderSend headerSender;
	
	@RequestMapping("/simplesend1")
	public String send1() {
		sender.send1();
		return "200";
	}
	
	@RequestMapping("/simplesend2")
	public String send2() {
		sender.send2();
		return "200";
	}

	@RequestMapping("/fanoutsend")
	public String fanoutsend() {
		fanoutSender.send();
		return "200";
	}
	
	@RequestMapping("/topicsend")
	public String topicsend() {
		topicSender.send();
		return "200";
	}
	
	@RequestMapping("/headersend")
	public String headersend() {
		headerSender.send();
		return "200";
	}
}
