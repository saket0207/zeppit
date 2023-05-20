package com.ecommerce.zeppitProduct.controller;

import com.ecommerce.zeppitProduct.entity.ProductImage;
import com.ecommerce.zeppitProduct.model.ApiResponse;
import com.ecommerce.zeppitProduct.repository.ProductImageRepository;
import com.ecommerce.zeppitProduct.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ecommerce.zeppitProduct.utility.Constants.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = API, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class ProductImageController {

    @Autowired
    ProductImageService productImageService;

    @GetMapping(ALL_PRODUCT_IMAGE)
    public ResponseEntity<ApiResponse<List<ProductImage>>> getAllProductImages(){
        ApiResponse<List<ProductImage>> productImages = productImageService.getAllProduct();
        return new ResponseEntity<>(productImages, HttpStatus.OK);

    }

    @GetMapping(PRODUCT_IMAGE_WITH_ID)
    public ResponseEntity<ApiResponse<ProductImage>> getProductImageWithId(@PathVariable(PRODUCT_IMAGE_ID) Integer productImageId){
        ApiResponse<ProductImage> productImageById = productImageService.getProductImageById(productImageId);
        return new ResponseEntity<>(productImageById, HttpStatus.OK);
    }

    @PostMapping(PRODUCT_IMAGE)
    public ResponseEntity<ApiResponse<ProductImage>> createProductImage(@RequestBody ProductImage productImage){
        ApiResponse<ProductImage> createdProductImage = productImageService.createProductImage(productImage);
        return new ResponseEntity<>(createdProductImage, HttpStatus.OK);
    }

    @PutMapping(PRODUCT_IMAGE_WITH_ID)
    public ResponseEntity<ApiResponse<ProductImage>> upadteProductImage(@PathVariable(PRODUCT_IMAGE_ID) Integer productImageId, @RequestBody ProductImage productImage){
        ApiResponse<ProductImage> productImageApiResponse = productImageService.updateProductImage(productImageId, productImage);
        return  new ResponseEntity<>(productImageApiResponse, HttpStatus.OK);
    }
    @DeleteMapping(PRODUCT_IMAGE_WITH_ID)
    public ResponseEntity<ApiResponse<Object>> deleteProductImageById(@PathVariable(PRODUCT_IMAGE_ID) Integer productImageId){
        ApiResponse<Object> objectApiResponse = productImageService.deleteProductImageById(productImageId);
        return new ResponseEntity<>(objectApiResponse, HttpStatus.OK);
    }
    @GetMapping(PRODUCT_IMAGE_WITH_PID)
    public ResponseEntity<ApiResponse<List<ProductImage>>> getAllImagesByProductId(@PathVariable(PRODUCT_ID) Integer productId){
        ApiResponse<List<ProductImage>> productImages =  productImageService.getProductImageByProductId(productId);
        return new ResponseEntity<>(productImages, HttpStatus.OK);
    }

}
