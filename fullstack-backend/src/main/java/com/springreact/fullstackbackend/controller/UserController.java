package com.springreact.fullstackbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.springreact.fullstackbackend.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	

}
