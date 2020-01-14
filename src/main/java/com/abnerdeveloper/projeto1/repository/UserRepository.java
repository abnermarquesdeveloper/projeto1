package com.abnerdeveloper.projeto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abnerdeveloper.projeto1.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	//Pode criar uma Query customizada com a anotação @Query...
	@Query("select u from User u where u.name like %?1%")
	User findByName(String name);
	
	User findByEmail(String email);
	
}
