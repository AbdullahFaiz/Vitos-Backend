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
    private OrderRepository orderRepository;
    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private OrderItemsRepository orderItemsRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @PostMapping
    public OrderResponse create(ServletRequest request, @RequestBody OrderDTO orderDTO, HttpServletResponse resp){
        OrderResponse response = new OrderResponse();
        List<ValidationError> errorList = new ArrayList<ValidationError>();


        try {
            Orders order = new Orders();
            User user = userRepository.findById(orderDTO.getUser().getUserId());
            order.setUser(user);
            order.setTotalBill(orderDTO.getTotalBill());
            order.setUser(orderDTO.getUser());
            order.setStatus("P");

            Orders savedOrder = orderRepository.save(order);

            Orders existOrder = orderRepository.findByOrderId(savedOrder.getOrderId());
            if(existOrder != null){
                List<Pizza> pizzaList = orderDTO.getPizza();
                for (Pizza pizza:pizzaList) {

                    Pizza updatePizza = pizzaRepository.findByPizzaId(pizza.getPizzaId());
                    if(pizza.getQuantity() <= updatePizza.getQuantity()) {
                        OrderItems orderItems = new OrderItems();
                        orderItems.setOrder(existOrder);
                        orderItems.setPizza(updatePizza);
                        orderItems.setQuantity(pizza.getQuantity());
                        orderItems.setApproveStatus("P");
                        orderItems.setStatus("Pending");
                        OrderItems savedOrderItems = orderItemsRepository.save(orderItems);


                        updatePizza.setQuantity(updatePizza.getQuantity() - pizza.getQuantity());
                        pizzaRepository.save(updatePizza);
                    }else{
                        double pizzaCost =  updatePizza.getUnitPrice();
                        existOrder.setTotalBill(existOrder.getTotalBill() - pizzaCost);

                        orderRepository.save(existOrder);
                    }


                }

            }else {
                response.setCode(ResponseEnum.ERROR.getCode());
                response.setMessage(ResponseEnum.ERROR.getMessage());
                return response;
            }

            List<Orders> orderList = new ArrayList<Orders>();
            orderList.add(existOrder);
            response.setOrders(orderList);
            response.setCode(ResponseEnum.SUCCESS.getCode());
            response.setMessage(ResponseEnum.SUCCESS.getMessage());
        } catch (Exception e) {
            response.setCode(ResponseEnum.SOMETHING_WENT_WRONG.getCode());
            response.setMessage(ResponseEnum.SOMETHING_WENT_WRONG.getMessage());
        }
        return response;
    }

    
    @GetMapping
    public OrderResponse getOrders(ServletRequest request){
        OrderResponse response = new OrderResponse();
        try{
            List<Orders> orders = orderRepository.findAll();
            response.setOrders(orders);
            response.setCode(ResponseEnum.SUCCESS.getCode());
            response.setMessage(ResponseEnum.SUCCESS.getMessage());
        }catch (Exception exception){
            response.setCode(ResponseEnum.SOMETHING_WENT_WRONG.getCode());
            response.setMessage(ResponseEnum.SOMETHING_WENT_WRONG.getMessage());
        }
        return response;
    }


}
