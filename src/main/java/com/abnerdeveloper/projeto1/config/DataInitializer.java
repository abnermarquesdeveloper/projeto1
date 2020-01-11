package com.abnerdeveloper.projeto1.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.abnerdeveloper.projeto1.entity.User;
import com.abnerdeveloper.projeto1.repository.UserRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		List<User> users = userRepository.findAll();
		
		if(users.isEmpty()) {
			User user = new User();
			user.setEmail("abner.marques@gmail.com.br");
			user.setName("Abner L. Marques");
			userRepository.save(user);
		}
	}

}
