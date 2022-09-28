package com.synergen.vitos.dto;

import com.synergen.vitos.model.User;

import java.util.List;

public class UserResponse {

	private int code;
	private String message;
	private List<User> user;
	private List<ValidationError> validationErrors;


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<ValidationError> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(List<ValidationError> validationErrors) {
		this.validationErrors = validationErrors;
	}
}
