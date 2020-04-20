package com.dalin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dalin.service.MailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMail {

	@Autowired
	private MailService mailService;
	
//	@Test
//	public void testSimpleMail() {
//		String to = "fjlls@qq.com";
//		String subject = "工作提醒";
//		String content = "离2020年的日子越来越近了！加油！！";
//		
//		mailService.sendSimpleMail(to, subject, content);
//	}
//	
//	@Test
//	public void testHtmlMail() {
//		String to = "fjlls@qq.com";
//		String subject = "工作提醒";
//		String content = "<html><body>"
//				+ "<h3>离2020年的日子越来越近了！加油！！</h3>"
//				+ "<hr>"
//				+ "</body></html>";
//		
//		mailService.sendHtmlMail(to, subject, content);
//	}
	
	@Test
	public void testFileMail() {
		String to = "fjlls@qq.com";
		String subject = "工作提醒";
		String content = "<html><body>"
				+ "<h3>离2021年的日子越来越近了！加油！！</h3>"
				+ "<hr>"
				+ "</body></html>";
		String filePath = "D:\\1\\good.txt";
		mailService.sendFileMail(to, subject, content, filePath);
	}
	
}
