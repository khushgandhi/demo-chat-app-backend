package com.chat.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long messageId;
	@Column
	private String messageText;
	@JoinColumn(name = "senderId",referencedColumnName = "userId")
	@OneToOne
	private User sender;
	@JoinColumn(name = "recieverId",referencedColumnName = "userId")
	@OneToOne
	private User reciever;
	@Column
	private LocalDateTime sentAt;
	
	public Message() {}
	

	public Message(String messageText, User sender, User reciever) {
		this.messageText = messageText;
		this.sender = sender;
		this.reciever = reciever;
		this.sentAt = LocalDateTime.now();
	}


	public Long getMessageId() {
		return messageId;
	}
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public User getReciever() {
		return reciever;
	}
	public void setReciever(User reciever) {
		this.reciever = reciever;
	}
	public LocalDateTime getSentAt() {
		return sentAt;
	}
	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}
}
