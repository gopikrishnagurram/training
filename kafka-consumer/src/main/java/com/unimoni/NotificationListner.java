package com.unimoni;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class NotificationListner {

	@Autowired
	private JavaMailSender sender;

	@KafkaListener(topics = "user_creation_email")
	public void listenForEmail(ConsumerRecord<String, User> consumerRecord) {
		User user = consumerRecord.value();
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setTo(user.getEmail());
			helper.setText("You are registered in unimoni with id " + user.getId());
			helper.setSubject("Account created successfully");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sender.send(message);
		System.out.println("processing completed");
	}

}
