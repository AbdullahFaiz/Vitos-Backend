package com.synergen.vitos.dto;

import com.synergen.vitos.model.Orders;

import java.util.List;

public class OrderResponse {

    private int code;
    private String message;
    private List<Orders> orders;
    private List<ValidationError> validationError;

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

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public List<ValidationError> getValidationError() {
        return validationError;
    }

    public void setValidationError(List<ValidationError> validationError) {
        this.validationError = validationError;
    }
}
