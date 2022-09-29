package com.synergen.vitos.dto;

import com.synergen.vitos.model.Pizza;
import com.synergen.vitos.model.User;

import java.util.List;

public class OrderDTO {
	private User user;
	private List<Pizza> pizza;

	private double totalBill;
	private String refernceNo;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Pizza> getPizza() {
		return pizza;
	}

	public void setPizza(List<Pizza> pizza) {
		this.pizza = pizza;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public String getRefernceNo() {
		return refernceNo;
	}

	public void setRefernceNo(String refernceNo) {
		this.refernceNo = refernceNo;
	}
}
