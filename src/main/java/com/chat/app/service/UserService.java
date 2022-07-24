package com.chat.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.chat.app.dto.UserDTO;
import com.chat.app.entity.User;
import com.chat.app.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public UserDTO saveUser(UserDTO userDTO)  {
		User user = new User();
		user.setName(userDTO.getName());
		User savedUser = null;
		try {
		savedUser = userRepo.save(user);
		} catch (DataIntegrityViolationException ex) {
			savedUser = userRepo.findByName(userDTO.getName());
		}
		return new UserDTO(savedUser);
	}

	public UserDTO getUser(Long userId) {
		User user = userRepo.getReferenceById(userId);
		UserDTO userDTO = new UserDTO(user);
		return userDTO;
	}

	public List<UserDTO> getAllUsers() {
		return userRepo.findAll().stream().map((user) -> {
			return new UserDTO(user);
		}).collect(Collectors.toList());
	}

	public List<UserDTO> filterUsers(String input) {
		return userRepo.getUsers(input.toLowerCase()).stream().map((user) -> {
			return new UserDTO(user);
		}).collect(Collectors.toList());
	}
}
