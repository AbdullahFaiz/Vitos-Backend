package com.synergen.vitos.dto;

import com.synergen.vitos.model.Category;
import com.synergen.vitos.model.Pizza;

import java.util.List;

public class PizzaDTO {

	private Category category;
	private List<Pizza> pizza;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Pizza> getPizza() {
		return pizza;
	}

	public void setPizza(List<Pizza> pizza) {
		this.pizza = pizza;
	}
}
