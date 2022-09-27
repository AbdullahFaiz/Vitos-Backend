package com.synergen.vitos.enums;


import com.synergen.vitos.dto.StatusResponseDTO;

import java.util.ArrayList;
import java.util.List;


public enum StatusEnum {
	ACTIVE("A", "Active"),
	INACTIVE("I", "Inactive"),
	PENDING("P","Pending");
		
	private String code;
	private String description;
	
	private StatusEnum(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	//get all
	public static List<StatusResponseDTO> getAll() {
		List<StatusResponseDTO> statusResposeDTOs = new ArrayList<StatusResponseDTO>();
		 for(StatusEnum enumObj : values()) {
			 StatusResponseDTO statusResposeDTO = new StatusResponseDTO();
			 statusResposeDTO.setCode(enumObj.getCode());
			 statusResposeDTO.setDescription(enumObj.getDescription());
			 statusResposeDTOs.add(statusResposeDTO);
	    }
		return statusResposeDTOs;
	}
	
	//get description by code
	public static String getDescriptionByCode(String code) {
		String returnData = "";
		 for(StatusEnum enumObj : values()) {
			 if(code.equals(enumObj.getCode())){
				 returnData = enumObj.getDescription();
			 }
	    }
		return returnData;
	}
}
