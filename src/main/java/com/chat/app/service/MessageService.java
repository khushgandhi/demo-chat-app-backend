package com.chat.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.app.dto.MessageDTO;
import com.chat.app.entity.Message;
import com.chat.app.entity.User;
import com.chat.app.repo.MessageRepository;

@Service
public class MessageService {
	@Autowired
	MessageRepository messageRepo;

	public List<MessageDTO> getAllMessages(Long sender, Long reciever) {
		return messageRepo.getMessages(sender, reciever).stream().map((m) -> {
			MessageDTO msgDTO = new MessageDTO(m);
			msgDTO.setSentByYou(sender==m.getSender().getUserId());
			return msgDTO;
		}).collect(Collectors.toList());
	}
	
	public MessageDTO send(Long senderId, Long recieverId, String message) throws Exception {
		if(senderId == recieverId) {
			throw new Exception("can't send to yourself");
		}
		User sender = new User(senderId);
		User reciever = new User(recieverId);
		Message msg = new Message(message, sender , reciever);
		MessageDTO masgDTO = new MessageDTO(messageRepo.save(msg));
		masgDTO.setSentByYou(true);
		return masgDTO;
	}
}
