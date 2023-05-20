package com.ecommerce.zeppitProduct.service;

import com.ecommerce.zeppitProduct.entity.Product;
import com.ecommerce.zeppitProduct.model.ApiResponse;
import com.ecommerce.zeppitProduct.model.ErrorApiResponse;
import com.ecommerce.zeppitProduct.model.SuccessApiResponse;
import com.ecommerce.zeppitProduct.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class ProductService {

    private static final Logger LOG = LogManager.getLogger(ProductService.class);
    @Autowired
    ProductRepository productRepository;
    public ApiResponse<Product> getProductById(Integer productId) {

        Optional<Product> product = productRepository.findById(productId);
        if(product.isEmpty()){
            return new ErrorApiResponse<Product>("Not Found", null);
        }
        return new SuccessApiResponse<Product>("Found Successfully", product.get());

    }

    public SuccessApiResponse<Product> createProduct(Product product) {

        Product savedProduct = productRepository.save(product);
        return new SuccessApiResponse<Product>("Successfully created", savedProduct);
    }

    public ApiResponse<Product> updateProduct(Integer productId, Product product) {

        Optional<Product> productById = productRepository.findById(productId);
        if(productById.isEmpty()){
            return new ErrorApiResponse<>("Id Not found", null);
        }

        Product updatedProduct = productRepository.save(product);
        return new SuccessApiResponse<Product>("Successfully updated", updatedProduct);
    }

    public ApiResponse<Object> deleteProductById(Integer productId) {

        try {
            productRepository.deleteById(productId);
        } catch (Exception ex){
            LOG.error("Error in deletion of the brand ", ex);
            return new ErrorApiResponse<Object>("Brand deletion Failed", null);
        }

        return new SuccessApiResponse<Object>("Brand deletion successful", null);

    }

    public ApiResponse<List<Product>> getAllProducts() {
        Iterable<Product> products = productRepository.findAll();
        List<Product> productList = StreamSupport.stream(products.spliterator(), false).toList();
        return new SuccessApiResponse<List<Product>>("Successfully fetched", productList);
    }
}
