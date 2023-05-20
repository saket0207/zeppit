package com.ecommerce.zeppitProduct.service;

import com.ecommerce.zeppitProduct.entity.Category;
import com.ecommerce.zeppitProduct.model.ApiResponse;
import com.ecommerce.zeppitProduct.model.ErrorApiResponse;
import com.ecommerce.zeppitProduct.model.SuccessApiResponse;
import com.ecommerce.zeppitProduct.repository.CategoryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class CategoryService {

    private static final Logger LOG = LogManager.getLogger(CategoryService.class);

    @Autowired
    CategoryRepository categoryRepository;
    public ApiResponse<List<Category>> getAllCategory() {
        Iterable<Category> categoriesIterable = categoryRepository.findAll();
        List<Category> categories = StreamSupport.stream(categoriesIterable.spliterator(), false).toList();
        return new SuccessApiResponse<List<Category>>("Fetched all categories Successfully", categories);
    }
    public ApiResponse<Category> getCategoryById(Integer categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isEmpty()){
            return new ErrorApiResponse<>("Failed to fetch the category for the given category id", null);
        }

        return new SuccessApiResponse<Category>("Successfully fetched the category for the given category id", category.get());
    }

    public ApiResponse<Category> createCategory(Category category) {
        Category createdCategory = categoryRepository.save(category);
        return new SuccessApiResponse<Category>("SuccessFully Created", createdCategory);
    }

    public ApiResponse<Category> updateCategory(Integer categoryId, Category category) {
        Optional<Category> categoryById = categoryRepository.findById(categoryId);
        if(categoryById.isEmpty()){
            return new ErrorApiResponse<>("Not present", null);
        }
        return new SuccessApiResponse<>("Successfully Updated", categoryById.get());
    }

    public ApiResponse<Object> deleteCategoryById(Integer categoryId) {

        try{
            categoryRepository.deleteById(categoryId);
        }catch (Exception e){
            LOG.error("Unable to delete", e);
            return new ErrorApiResponse<Object>("Failed to delete", null);
        }

        return new SuccessApiResponse<>("Successfully deleted ", null);
    }
}
