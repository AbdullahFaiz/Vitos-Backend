package com.synergen.vitos.repository;

import com.synergen.vitos.model.OrderItems;
import com.synergen.vitos.model.Orders;
import com.synergen.vitos.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {
    public OrderItems findById(long orderItemId);

    public List<OrderItems> findByOrder(Orders orders);

    public List<OrderItems> findByPizza(Pizza pizza);
}
