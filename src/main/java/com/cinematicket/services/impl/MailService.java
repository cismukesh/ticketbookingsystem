package com.cinematicket.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * This uses the java mail API to send the email
 */
@Service
public class MailService {

	@Value("${spring.mail.fromEmail}")
	private String fromAddress;

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendMail(String subject, String body, String to) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(to);
		msg.setSubject(subject);
		msg.setText(body);
		javaMailSender.send(msg);
	}

}