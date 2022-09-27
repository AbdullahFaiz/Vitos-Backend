package com.synergen.vitos.enums;

public enum ValidationErrorEnum {

	ALREADY_EXISTS("Already exists"),
	ALREADY_ACTIVATED("Already exists an active record"),
	NOT_FOUND("Not found");
	
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	private ValidationErrorEnum(String message) {
		this.message = message;
	}
}
