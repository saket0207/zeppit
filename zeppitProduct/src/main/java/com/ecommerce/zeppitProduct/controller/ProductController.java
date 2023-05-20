package com.ecommerce.zeppitProduct.controller;

import com.ecommerce.zeppitProduct.entity.Product;
import com.ecommerce.zeppitProduct.model.ApiResponse;
import com.ecommerce.zeppitProduct.repository.ProductRepository;
import com.ecommerce.zeppitProduct.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ecommerce.zeppitProduct.utility.Constants.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = API, consumes = MediaType.APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class ProductController {

    private static final Logger LOG = LogManager.getLogger(ProductController.class);

    @Autowired
    ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(ALL_PRODUCT)
    public ResponseEntity<ApiResponse<List<Product>>> getAllProducts(){
        LOG.info("Get all products controller execution starts ");
        ApiResponse<List<Product>> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);

    }
    @GetMapping(PRODUCT_WITH_ID)
    public ResponseEntity<ApiResponse<Product>> getProductById(@PathVariable(PRODUCT_ID) Integer productId){

        LOG.info("Get Product controller execution starts ");
        ApiResponse<Product> productById = productService.getProductById(productId);
        return new ResponseEntity<ApiResponse<Product>>(productById, HttpStatus.OK);
    }

    @PostMapping(PRODUCT)
    public ResponseEntity<ApiResponse<Product>> createProduct(@RequestBody Product product){
        LOG.info("Create Product controller execution starts ");
        ApiResponse<Product> productApiResponse = productService.createProduct(product);

        return new ResponseEntity<>(productApiResponse, HttpStatus.CREATED);

    }

    @PutMapping(PRODUCT_WITH_ID)
    public ResponseEntity<ApiResponse<Product>> updateProduct(@PathVariable(PRODUCT_ID) Integer productId, @RequestBody Product product){

        LOG.info("Update Product controller execution starts ");
        ApiResponse<Product> productApiResponse = productService.updateProduct(productId, product);
        return new ResponseEntity<>(productApiResponse, HttpStatus.OK);
    }

    @DeleteMapping(PRODUCT_WITH_ID)
    public ResponseEntity<ApiResponse<Object>> deleteProductById(@PathVariable(PRODUCT_ID) Integer productId){

        ApiResponse<Object> productApiResponse = productService.deleteProductById(productId);
        return new ResponseEntity<>(productApiResponse, HttpStatus.OK);

    }


}
