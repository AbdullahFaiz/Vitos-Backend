package com.synergen.vitos.service;

import com.synergen.vitos.dto.CategoryResponse;
import com.synergen.vitos.dto.ValidationError;
import com.synergen.vitos.enums.ResponseEnum;
import com.synergen.vitos.enums.ValidationErrorEnum;
import com.synergen.vitos.model.Category;
import com.synergen.vitos.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public CategoryResponse createCategory(Category category) {

        CategoryResponse response = new CategoryResponse();
        List<ValidationError> validationErrors = new ArrayList<ValidationError>();

        try{
            Category existCategory =  categoryRepository.findByCode(category.getCode());
            if(existCategory == null){
                category.setCode(category.getCode());
                category.setDescription(category.getDescription());
                category.setStatus(category.getStatus());

                Category savedCategory = categoryRepository.save(category);

                response.setCreatedCategory(savedCategory);
                response.setCode(ResponseEnum.SUCCESS.getCode());
                response.setMessage(ResponseEnum.SUCCESS.getMessage());
            }else{
                response.setCode(ResponseEnum.VALIDATION_ERROR.getCode());
                response.setMessage(ResponseEnum.VALIDATION_ERROR.getMessage());

                ValidationError error = new ValidationError();
                error.setKey("category");
                error.setMessage(ValidationErrorEnum.NOT_FOUND.getMessage());

                validationErrors.add(error);
            }

        }catch(Exception e){
            response.setCode(ResponseEnum.SOMETHING_WENT_WRONG.getCode());
            response.setMessage(e.getLocalizedMessage());
        }

        return response;

    }

    public CategoryResponse getAll() {
        CategoryResponse response = new CategoryResponse();
        try {
            List<Category> categoryList = categoryRepository.findAll();


            response.setCode(ResponseEnum.SUCCESS.getCode());
            response.setMessage(ResponseEnum.SUCCESS.getMessage());
            response.setResponseData(categoryList);
        } catch (Exception e) {
            response.setCode(ResponseEnum.SOMETHING_WENT_WRONG.getCode());
            response.setMessage(ResponseEnum.SOMETHING_WENT_WRONG.getMessage());
        }

        return response;
    }
}
