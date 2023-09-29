package com.springreact.fullstackbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springreact.fullstackbackend.exception.UserNotFoundException;
import com.springreact.fullstackbackend.model.User;
import com.springreact.fullstackbackend.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user")
	User newUser(@Valid @RequestBody User newUser) {
		return userRepository.save(newUser);
				
	}
	
	@GetMapping("/users")
	List<User>getAllUsers() {
		return userRepository.findAll();
	}
	

	@GetMapping("/users/{id}")
	User getUserById(@PathVariable Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException(id) );
	}
	
	@PutMapping("/users/{id}")
	User updateUser(@Valid @RequestBody User newUser, @PathVariable Long id) {
		return userRepository.findById(id)
				.map(user -> {
					user.setName(newUser.getName());
					user.setUsername(newUser.getUsername());
					user.setEmail(newUser.getEmail());
					return userRepository.save(user);
				}).orElseThrow(() -> new UserNotFoundException(id)); 
	}
	

}
