package com.nagarro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entitys.User;
import com.nagarro.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	 private final UserService userService;

	    @Autowired
	    public UserController(UserService userService) {
	        this.userService = userService;
	    }
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(){
		List<User> list=this.userService.getAllUsers();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.status(HttpStatus.CREATED).body(list);
		}	
	}
	@GetMapping("/user/{username}")
	public ResponseEntity<User> getUser(@PathVariable("username") String username){
		User user=userService.getUser(username);
		if(user==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(user));
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User u=null;
		try {
			u=this.userService.addUser(user);
			return ResponseEntity.of(Optional.of(u));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}