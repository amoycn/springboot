package com.dalin.service;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Value("fu2019@qq.com")
	private String from;
	
	/**
	 * 发送简单的邮件
	 * 只包含标题和文字正文
	 */
	public void sendSimpleMail(String to, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		
		try {
			mailSender.send(message);
			System.out.println("发送邮件成功");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("发送邮件失败");
		}
	}
	
	/**
	 * 发送Html的邮件
	 */
	public void sendHtmlMail(String to, String subject, String content) {
		MimeMessage mime = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper message = new MimeMessageHelper(mime);
			message.setFrom(from);
			message.setTo(to);
			message.setSubject(subject);
			message.setText(content, true);
			mailSender.send(mime);
			System.out.println("发送邮件成功");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("发送邮件失败");
		}
	}
	
	/**
	 * 发送带附件的邮件
	 */
	public void sendFileMail(String to, String subject, String content, String filePath) {
		MimeMessage mime = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper message = new MimeMessageHelper(mime, true);
			message.setFrom(from);
			message.setTo(to);
			message.setSubject(subject);
			message.setText(content, true);
			
			FileSystemResource file = new FileSystemResource(new File(filePath));
			String fileName = "附件测试的文件名";
			message.addAttachment(fileName, file);
			
			mailSender.send(mime);
			System.out.println("发送邮件成功");
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("发送邮件失败");
		}
	}
}
