package com.ecommerce.zeppitProduct.controller;

import com.ecommerce.zeppitProduct.entity.Category;
import com.ecommerce.zeppitProduct.model.ApiResponse;
import com.ecommerce.zeppitProduct.service.CategoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ecommerce.zeppitProduct.utility.Constants.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = API, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class CategoryController {

    private static final Logger LOG = LogManager.getLogger(CategoryController.class);
    @Autowired
    CategoryService categoryService;

    @GetMapping(CATEGORY_WITH_ID)
    public ResponseEntity<ApiResponse<Category>> getCategoryById(@PathVariable(CATEGORY_ID) Integer categoryId){
        ApiResponse<Category> category = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping(ALL_CATEGORY)
    public ResponseEntity<ApiResponse<List<Category>>> getAllCategories(){
        ApiResponse<List<Category>> categoriesApiResponse = categoryService.getAllCategory();
        LOG.info("Category List: \n", categoriesApiResponse);

        return new ResponseEntity<>(categoriesApiResponse, HttpStatus.OK);
    }

    @PostMapping(CATEGORY)
    public ResponseEntity<ApiResponse<Category>> createCategory(@RequestBody Category category){

        ApiResponse<Category> createCategoryApiResponse = categoryService.createCategory(category);
        LOG.info("Category successfully added!!!");
        return new ResponseEntity<>(createCategoryApiResponse, HttpStatus.CREATED);
    }

    @PutMapping(CATEGORY_WITH_ID)
    public ResponseEntity<ApiResponse<Category>> updateCategory(@PathVariable Integer categoryId, @RequestBody Category category){
        ApiResponse<Category> categoryApiResponse = categoryService.updateCategory(categoryId, category);
        return new ResponseEntity<>(categoryApiResponse, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(CATEGORY_ID)
    public void deleteCategoryById(@PathVariable(CATEGORY_ID) Integer categoryId){
        ApiResponse<Object> objectApiResponse = categoryService.deleteCategoryById(categoryId);

        new ResponseEntity<>(objectApiResponse, HttpStatus.OK);
    }

}
