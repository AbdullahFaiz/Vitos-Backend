package com.synergen.vitos.model;


import com.synergen.vitos.dto.BaseData;

import javax.persistence.*;

@Entity
public class Orders extends BaseData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long orderId;
    @ManyToOne
    private User user;
    private double totalBill;

    private String refernceNo;
    private String status;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }


    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRefernceNo() {
        return refernceNo;
    }

    public void setRefernceNo(String refernceNo) {
        this.refernceNo = refernceNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
