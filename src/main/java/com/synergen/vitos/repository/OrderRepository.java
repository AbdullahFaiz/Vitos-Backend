package com.synergen.vitos.repository;

import com.synergen.vitos.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    public Orders findByOrderId(long orderId);

}
