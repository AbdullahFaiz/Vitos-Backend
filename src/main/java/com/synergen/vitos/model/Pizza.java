package com.synergen.vitos.model;


import com.synergen.vitos.dto.BaseData;

import javax.persistence.*;

@Entity
public class Pizza extends BaseData {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long pizzaId;
	private String code;
	private String description;
	@ManyToOne
	private Category category;
	private String status;
	private String imgURL;


	public long getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(long pizzaId) {
		this.pizzaId = pizzaId;
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

	public Category getCategory() { return category; }

	public void setCategory(Category category) { this.category = category; }
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	
	
}
