package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.entitys.User;
import com.nagarro.repository.UserRepository;

@Component
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	public List<User> getAllUsers(){
		List<User> users=(List<User>) this.userRepo.findAll();
		return users;
	}
	public User getUser(String Username) {
		User user=null;
		try {
			user=this.userRepo.findByUsername(Username);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public User addUser(User user) {
		User result=userRepo.save(user);
		return result;
	}
}
