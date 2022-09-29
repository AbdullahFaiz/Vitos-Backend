package com.synergen.vitos.controller;

import com.synergen.vitos.dto.CategoryResponse;
import com.synergen.vitos.dto.ValidationError;
import com.synergen.vitos.enums.ResponseEnum;
import com.synergen.vitos.enums.ValidationErrorEnum;
import com.synergen.vitos.model.Category;
import com.synergen.vitos.repository.CategoryRepository;
import com.synergen.vitos.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins="*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping
    public CategoryResponse createCategory(Category category) {

        CategoryResponse response = new CategoryResponse();
        response = categoryService.createCategory(category);


        return response;

    }

    @GetMapping
    public CategoryResponse getAll() {
        CategoryResponse response = new CategoryResponse();
        response = categoryService.getAll();


        return response;
    }


}
