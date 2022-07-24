package com.chat.app.dto;

import com.chat.app.entity.User;

public class UserDTO {

	private long userId;
	private String name;
	
	public UserDTO(User user) {
		this.userId = user.getUserId();
		this.name = user.getName();
	}
	
	public UserDTO() {
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
