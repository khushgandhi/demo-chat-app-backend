package com.chat.app.dto;

import java.time.LocalDateTime;

import com.chat.app.entity.Message;

public class MessageDTO {

	private String message;
	private Long senderId;
	private Long recieverId;
	private LocalDateTime sentAt;
	private boolean isSentByYou;
	
	public MessageDTO(Message messageEntity) {
		this.message = messageEntity.getMessageText();
		this.senderId = messageEntity.getSender().getUserId();
		this.recieverId = messageEntity.getReciever().getUserId();
		this.sentAt = messageEntity.getSentAt();
	}
	public MessageDTO() {
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getSentAt() {
		return sentAt;
	}
	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}
	public Long getSenderId() {
		return senderId;
	}
	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}
	public Long getRecieverId() {
		return recieverId;
	}
	public void setRecieverId(Long recieverId) {
		this.recieverId = recieverId;
	}
	public boolean isSentByYou() {
		return isSentByYou;
	}
	public void setSentByYou(boolean isSentByYou) {
		this.isSentByYou = isSentByYou;
	}
}
