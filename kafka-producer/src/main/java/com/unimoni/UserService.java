package com.unimoni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author gopi
 *
 */
@Service
public class UserService {

	@Autowired
	KafkaService kafkaService;

	@Autowired
	UserRepository userRepository;

	public User saveUser(User user) {
		User duser = userRepository.save(user);
		if (duser != null) {
			kafkaService.sendNotification(duser);
		}
		return duser;
	}

}
