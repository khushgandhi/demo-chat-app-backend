package com.chat.app.dto;


public class ErrorResponseDTO {

	private String message;
	private String errorMessage;
	private int errorCode;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public ErrorResponseDTO(String message, String errorMessage, int errorCode) {
		super();
		this.message = message;
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
}
