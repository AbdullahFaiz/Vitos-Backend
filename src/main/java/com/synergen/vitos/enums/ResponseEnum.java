package com.synergen.vitos.enums;

public enum ResponseEnum {
	
	SUCCESS(200, "Success"),
	ERROR(400, "Error"),
	VALIDATION_ERROR(401, "Validation Error"),
	
	//login
	INVALID_LOGIN(402,"Invalid login credentials"),
	INACTIVE_LOGIN(403,"Your Account has not been activated yet."),
	UNAUTHORIZED_ACCESS(405,"Unauthorized access"),
		
	NOT_FOUNT(404, "Not Found"),
	SOMETHING_WENT_WRONG(406, "Something Went Wrong"),
	USERNAME_NOT_FOUND(407, "User Not Found!"),
	PASSWORD_INCORRECT(408, "Password Incorrect!"),
	RESET_PASSWORD(409, "Please Reset Password!");

	private int code;
	private String message;
	
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
	
	private ResponseEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
}
