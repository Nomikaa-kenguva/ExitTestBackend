package com.nagarro.repository;


import org.springframework.data.repository.CrudRepository;

import com.nagarro.entitys.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	public User findByEmail(String email);
	public User findByUsername(String username);
	
}
