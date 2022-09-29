package com.synergen.vitos.controller;

import com.synergen.vitos.dto.OrderDTO;
import com.synergen.vitos.dto.OrderResponse;
import com.synergen.vitos.dto.ValidationError;
import com.synergen.vitos.enums.ResponseEnum;
import com.synergen.vitos.model.OrderItems;
import com.synergen.vitos.model.Orders;
import com.synergen.vitos.model.Pizza;
import com.synergen.vitos.model.User;
import com.synergen.vitos.repository.OrderItemsRepository;
import com.synergen.vitos.repository.OrderRepository;
import com.synergen.vitos.repository.PizzaRepository;
import com.synergen.vitos.repository.UserRepository;
import com.synergen.vitos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins="*")
public class OrderController {

    @Autowired
    private OrderService orderservice;

    @Transactional
    @PostMapping
    public OrderResponse create(@RequestBody OrderDTO orderDTO){
        OrderResponse response = new OrderResponse();
        response = orderservice.create(orderDTO);

        return response;
    }

    
    @GetMapping
    public OrderResponse getOrders(){
        OrderResponse response = new OrderResponse();
        response = orderservice.getOrders();

        return response;
    }


}
