package com.synergen.vitos.dto;

import com.synergen.vitos.model.Category;

import java.util.List;

public class CategoryResponse {

	private int code;
	private String message;
	private List<Category> responseData;
	private Category createdCategory;
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
	public List<Category> getResponseData() {
		return responseData;
	}
	public void setResponseData(List<Category> responseData) {
		this.responseData = responseData;
	}
	public List<ValidationError> getValidationErrors() {
		return validationErrors;
	}
	public void setValidationErrors(List<ValidationError> validationErrors) {
		this.validationErrors = validationErrors;
	}

	public Category getCreatedCategory() {
		return createdCategory;
	}

	public void setCreatedCategory(Category createdCategory) {
		this.createdCategory = createdCategory;
	}
}
