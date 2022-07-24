package com.chat.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.app.dto.MessageDTO;
import com.chat.app.service.MessageService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MessageController {
	
	@Autowired
	MessageService messageService;

	@GetMapping("/messages/{sender}/{reciever}")
	public List<MessageDTO> getAllMessages(@PathVariable Long sender, @PathVariable Long reciever) {
		return messageService.getAllMessages(sender, reciever);
	}
	
	@PostMapping("/send")
	public MessageDTO sendMessage(@RequestBody MessageDTO messageDTO) throws Exception {
		return messageService.send(messageDTO.getSenderId(), messageDTO.getRecieverId(), messageDTO.getMessage());
	}
}
