package com.synergen.vitos.dto;

import com.synergen.vitos.model.Pizza;

import java.util.List;

public class PizzaByCategoryResponse {

	private int code;
	private String message;
	private List<PizzaDTO> responseData;
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
	public List<PizzaDTO> getResponseData() {
		return responseData;
	}
	public void setResponseData(List<PizzaDTO> responseData) {
		this.responseData = responseData;
	}
	public List<ValidationError> getValidationErrors() {
		return validationErrors;
	}
	public void setValidationErrors(List<ValidationError> validationErrors) {
		this.validationErrors = validationErrors;
	}
	
	
}
