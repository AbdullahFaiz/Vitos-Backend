package com.synergen.vitos.controller;

import com.synergen.vitos.dto.PizzaByCategoryResponse;
import com.synergen.vitos.dto.PizzaDTO;
import com.synergen.vitos.dto.PizzaResponse;
import com.synergen.vitos.dto.ValidationError;
import com.synergen.vitos.enums.ResponseEnum;
import com.synergen.vitos.enums.ValidationErrorEnum;
import com.synergen.vitos.model.Category;
import com.synergen.vitos.model.Pizza;
import com.synergen.vitos.repository.CategoryRepository;
import com.synergen.vitos.repository.PizzaRepository;
import com.synergen.vitos.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pizza")
@CrossOrigin(origins="*")
public class PizzaController {


    @Autowired
    private PizzaService pizzaService;

    @PostMapping
    public PizzaResponse createPizza(ServletRequest request, @RequestBody Pizza pizza) {

        PizzaResponse response = new PizzaResponse();

        response = pizzaService.createPizza(pizza);

        return response;

    }

    @GetMapping
    public PizzaResponse getAll() {
        PizzaResponse response = new PizzaResponse();
        response = pizzaService.getAll();

        return response;
    }


    @GetMapping("/category-wise")
    public PizzaByCategoryResponse getCategoryWisePizza() {
        PizzaByCategoryResponse response = new PizzaByCategoryResponse();
        response = pizzaService.getCategoryWisePizza();
        return response;
    }
}
