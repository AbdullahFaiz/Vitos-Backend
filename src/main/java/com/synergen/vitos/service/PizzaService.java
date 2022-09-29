package com.synergen.vitos.service;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public PizzaResponse createPizza(Pizza pizza) {

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
                    pizza.setImgURL(pizza.getImgURL());
                    pizza.setStatus(pizza.getStatus());
                    pizza.setUnitPrice(pizza.getUnitPrice());
                    pizza.setQuantity(pizza.getQuantity());

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
        response.setValidationErrors(validationErrors);

        return response;

    }

    public PizzaResponse getAll() {
        PizzaResponse response = new PizzaResponse();

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


    public PizzaByCategoryResponse getCategoryWisePizza() {
        PizzaByCategoryResponse response = new PizzaByCategoryResponse();
        List<PizzaDTO> responseData = new ArrayList<PizzaDTO>();
        try {

            List<Category> categories = categoryRepository.findAll();
            for (Category category : categories) {
                List<Pizza> pizzaList = pizzaRepository.findByCategory(category);
                PizzaDTO pizzaDTO = new PizzaDTO();
                pizzaDTO.setPizza(pizzaList);
                pizzaDTO.setCategory(category);
                responseData.add(pizzaDTO);
            }

            response.setResponseData(responseData);
            response.setCode(ResponseEnum.SUCCESS.getCode());
            response.setMessage(ResponseEnum.SUCCESS.getMessage());
        } catch (Exception e) {
            response.setCode(ResponseEnum.SOMETHING_WENT_WRONG.getCode());
            response.setMessage(e.getLocalizedMessage());
        }
        return response;
    }
}
