package com.ecommerce.zeppitProduct.controller;

import com.ecommerce.zeppitProduct.entity.ProductImage;
import com.ecommerce.zeppitProduct.entity.ProductReview;
import com.ecommerce.zeppitProduct.model.ApiResponse;
import com.ecommerce.zeppitProduct.service.ProductReviewService;
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
public class ProductReviewController {

    private static final Logger LOG = LogManager.getLogger(ProductController.class);
    @Autowired
    ProductReviewService productReviewService;

    @GetMapping(ALL_PRODUCT_REVIEW)
    public ResponseEntity<ApiResponse<List<ProductReview>>> getAllProductReviews(){

        ApiResponse<List<ProductReview>> productReviews = productReviewService.getAllProductReviews();
        return new ResponseEntity<>(productReviews, HttpStatus.OK);


    }
    @GetMapping(PRODUCT_REVIEW_WITH_ID)
    public ResponseEntity<ApiResponse<ProductReview>> getProductReviewById(@PathVariable(PRODUCT_REVIEW_ID) Integer productReviewId){
        ApiResponse<ProductReview> productReviewById = productReviewService.getProductReviewById(productReviewId);
        return new ResponseEntity<>(productReviewById, HttpStatus.OK);
    }

    @PostMapping(PRODUCT_REVIEW)
    public ResponseEntity<ApiResponse<ProductReview>> createProductReview(@RequestBody ProductReview productReview){

        ApiResponse<ProductReview> productReviewApiResponse = productReviewService.createProductReview(productReview);
        return new ResponseEntity<>(productReviewApiResponse, HttpStatus.CREATED);
    }

    @PutMapping(PRODUCT_REVIEW_WITH_ID)
    public ResponseEntity<ApiResponse<ProductReview>> updateProductReview(@PathVariable(PRODUCT_REVIEW_ID) Integer productReviewId, @RequestBody ProductReview productReview){
        ApiResponse<ProductReview> productReviewApiResponse = productReviewService.updateProductReview(productReviewId, productReview);
        return new ResponseEntity<>(productReviewApiResponse, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(PRODUCT_REVIEW_WITH_ID)
    public ResponseEntity<ApiResponse<Object>> deleteProductReviewById(@PathVariable(PRODUCT_REVIEW_ID) Integer productReviewId){

        ApiResponse<Object> productReviewApiResponse = productReviewService.deleteProductReviewById(productReviewId);
        return new ResponseEntity<>(productReviewApiResponse, HttpStatus.OK);

    }

    @GetMapping(PRODUCT_REVIEW_WITH_PID)
    public ResponseEntity<ApiResponse<List<ProductReview>>> getAllReviewsByProductId(@PathVariable(PRODUCT_ID) Integer productId){
        ApiResponse<List<ProductReview>> productReviews =  productReviewService.getProductReviewsByProductId(productId);
        return new ResponseEntity<>(productReviews, HttpStatus.OK);
    }
}
