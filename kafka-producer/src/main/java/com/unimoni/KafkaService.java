package com.unimoni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;

	public void sendNotification(User user) {
		publishMessageEvent(user);
		publishEmailEvent(user);
	}

	public void publishMessageEvent(User user) {
		kafkaTemplate.send("user_creation_phone", user);
	}

	public void publishEmailEvent(User user) {
		kafkaTemplate.send("user_creation_email", user);
	}

}
