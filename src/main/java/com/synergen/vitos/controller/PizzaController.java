package com.synergen.vitos.controller;

import com.synergen.vitos.dto.PizzaDTO;
import com.synergen.vitos.dto.PizzaResponse;
import com.synergen.vitos.dto.ValidationError;
import com.synergen.vitos.enums.ResponseEnum;
import com.synergen.vitos.enums.ValidationErrorEnum;
import com.synergen.vitos.model.Category;
import com.synergen.vitos.model.Pizza;
import com.synergen.vitos.repository.CategoryRepository;
import com.synergen.vitos.repository.PizzaRepository;
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
    private PizzaRepository pizzaRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    public PizzaResponse createPizza(ServletRequest request, @RequestBody Pizza pizza) {

        PizzaResponse response = new PizzaResponse();
        List<ValidationError> validationErrors = new ArrayList<ValidationError>();

        try{
            Pizza existPizza =  pizzaRepository.findByCode(pizza.getCode());
            if(existPizza == null){
                Category checkCategory =  categoryRepository.findByCode(pizza.getCategory().getCode());
                if(checkCategory != null) {
                    pizza.setCategory(checkCategory);
                    pizza.setCode(pizza.getCode());
                    pizza.setDescription(pizza.getDescription());
                    pizza.setStatus(pizza.getStatus());

                    pizzaRepository.save(pizza);

                    response.setCode(ResponseEnum.SUCCESS.getCode());
                    response.setMessage(ResponseEnum.SUCCESS.getMessage());
                }else{

                }
            }else{
                response.setCode(ResponseEnum.VALIDATION_ERROR.getCode());
                response.setMessage(ResponseEnum.VALIDATION_ERROR.getMessage());

                ValidationError error = new ValidationError();
                error.setKey("code");
                error.setMessage(ValidationErrorEnum.ALREADY_EXISTS.getMessage());

                validationErrors.add(error);
            }

        }catch(Exception e){
            response.setCode(ResponseEnum.SOMETHING_WENT_WRONG.getCode());
            response.setMessage(e.getLocalizedMessage());
        }

        return response;

    }

    @GetMapping
    public PizzaResponse getAll() {
        PizzaResponse response = new PizzaResponse();
//        List<PizzaDTO> responseData = new ArrayList<PizzaDTO>();

        try {
            List<Pizza> pizzaList = pizzaRepository.findAll();


            response.setCode(ResponseEnum.SUCCESS.getCode());
            response.setMessage(ResponseEnum.SUCCESS.getMessage());
            response.setResponseData(pizzaList);
        } catch (Exception e) {
            response.setCode(ResponseEnum.SOMETHING_WENT_WRONG.getCode());
            response.setMessage(ResponseEnum.SOMETHING_WENT_WRONG.getMessage());
        }

        return response;
    }


}
