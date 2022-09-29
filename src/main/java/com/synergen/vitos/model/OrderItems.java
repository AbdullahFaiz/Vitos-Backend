package com.synergen.vitos.model;

import com.synergen.vitos.dto.BaseData;

import javax.persistence.*;

@Entity
public class OrderItems extends BaseData
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long orderItemId;
    @ManyToOne
    private Orders order;
    @ManyToOne
    private Pizza pizza;
    private double quantity;
    private String approveStatus;
    private String status;

    public long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
