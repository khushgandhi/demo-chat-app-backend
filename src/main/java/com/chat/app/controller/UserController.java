package com.chat.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.app.dto.UserDTO;
import com.chat.app.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public UserDTO registerUser(@RequestBody UserDTO user)  {
		return userService.saveUser(user);
	}
	
	@GetMapping("/user/{userId}")
	public UserDTO getUser(@PathVariable Long userId) {
		return userService.getUser(userId);
	}
	
	@GetMapping("/users")
	public List<UserDTO> getUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{name}")
	public List<UserDTO> getUsers(@PathVariable String name){
		return userService.filterUsers(name);
	}
}
