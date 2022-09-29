package com.synergen.vitos.dto;

import com.synergen.vitos.model.OrderItems;

import java.util.List;

public class OrderItemsResponse {

    private int code;
    private String message;
    private List<OrderItems> orderItems;
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

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

    public List<ValidationError> getValidationError() {
        return validationError;
    }

    public void setValidationError(List<ValidationError> validationError) {
        this.validationError = validationError;
    }
}
