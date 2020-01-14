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
			createUser("João da Silva", "Joaos@gmail.com");
			createUser("Abner Lisboa Marques", "abner.marques@gmal.com");
			createUser("Maria Aparecida", "mariaapa@gmail.com");
		}
		
		//Pesquisa no banco por ID...
		/*User user = userRepository.getOne(2L);
		System.out.println(user.getName());*/
		
		//Apaga do banco um registro específico por ID...
		//userRepository.deleteById(2L);
		
		//Altera um registro por ID...
		/*User user = userRepository.getOne(1L);
		user.setEmail("joaodasilva@gmail.com");
		userRepository.save(user);*/
		
		//Busca com método customizado para busca pelo nome. é só definir o método na inteface que herda jpaRepository,
		//e usar aqui...
		//User user = userRepository.findByName("Maria Aparecida");
		//System.out.println(user.getName());
		User user = userRepository.findByEmail("abner.marques@gmal.com");
		System.out.print(user.getEmail());
	}
	public void createUser(String name, String email) {
		
		User user = new User(name, email);
		userRepository.save(user);
	}

}
