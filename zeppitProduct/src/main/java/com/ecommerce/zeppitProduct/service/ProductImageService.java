package com.ecommerce.zeppitProduct.service;

import com.ecommerce.zeppitProduct.entity.ProductImage;
import com.ecommerce.zeppitProduct.model.ApiResponse;
import com.ecommerce.zeppitProduct.model.ErrorApiResponse;
import com.ecommerce.zeppitProduct.model.SuccessApiResponse;
import com.ecommerce.zeppitProduct.repository.ProductImageRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class ProductImageService {

    private static final Logger LOG = LogManager.getLogger(ProductImageService.class);
    @Autowired
    ProductImageRepository productImageRepository;

    public ApiResponse<List<ProductImage>> getAllProduct(){
        Iterable<ProductImage> productImagesIterable = productImageRepository.findAll();
        List<ProductImage> productImages = StreamSupport.stream(productImagesIterable.spliterator(), false).toList();

        return new SuccessApiResponse<List<ProductImage>>("Successfully fetched", productImages);
    }

    public ProductImage getBroductImageById(Integer productImageId){
        ProductImage productImage = new ProductImage();

        return productImage;
    }

    public ApiResponse<ProductImage> createProductImage(ProductImage productImage){

        ProductImage savedProductImage = productImageRepository.save(productImage);
        return new SuccessApiResponse<>("SuccessFully created", savedProductImage);


    }

    public ApiResponse<ProductImage> updateProductImage(Integer productImageId, ProductImage productImage){
        Optional<ProductImage> productImageById = productImageRepository.findById(productImageId);
        if(productImageById.isEmpty()){
            return new ErrorApiResponse<>("Not Found ", null);
        }
        productImage.setProductId(productImageId);
        productImageRepository.save(productImage);
        return new SuccessApiResponse<ProductImage>("Successfully Updated ", productImage);


    }

    public ApiResponse<Object> deleteProductImageById(Integer productImageId){

        try {
            productImageRepository.deleteById(productImageId);
        }catch (Exception e){
            LOG.error("Unable to delete", e);
            return new ErrorApiResponse<>("Unable to delete", null);
        }
        return new SuccessApiResponse<>("Successfully deleted", null);

    }

    public ApiResponse<ProductImage> getProductImageById(Integer productImageId) {

        Optional<ProductImage> productImage = productImageRepository.findById(productImageId);
        if(productImage.isEmpty()){
            return new ErrorApiResponse<>("Not found", null);
        }

        return new SuccessApiResponse<ProductImage>("Fetched successfully  ", productImage.get());
    }

    public ApiResponse<List<ProductImage>> getProductImageByProductId(Integer productId) {
        List<ProductImage> allByProductId = productImageRepository.fetchAllByProductId(productId);
        if(allByProductId == null || allByProductId.isEmpty()){
            return new ErrorApiResponse<>("No image found for the given product id", null);
        }else {
            return new SuccessApiResponse<>("Found Images ", allByProductId);
        }
    }
}
