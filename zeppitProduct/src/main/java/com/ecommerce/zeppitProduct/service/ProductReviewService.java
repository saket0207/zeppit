package com.ecommerce.zeppitProduct.service;

import com.ecommerce.zeppitProduct.entity.ProductReview;
import com.ecommerce.zeppitProduct.model.ApiResponse;
import com.ecommerce.zeppitProduct.model.ErrorApiResponse;
import com.ecommerce.zeppitProduct.model.SuccessApiResponse;
import com.ecommerce.zeppitProduct.repository.ProductReviewRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class ProductReviewService {

    private static final Logger LOG = LogManager.getLogger(ProductReviewService.class);

    @Autowired
    ProductReviewRepository productReviewRepository;

    public ApiResponse<List<ProductReview>> getAllProductReviews(){

        Iterable<ProductReview> productReviewIterable = productReviewRepository.findAll();
        List<ProductReview> productReviews = StreamSupport.stream(productReviewIterable.spliterator(), false).toList();
        return new SuccessApiResponse<List<ProductReview>>("Success fetched all product reviews ", productReviews);
    }

    public ApiResponse<ProductReview> getProductReviewById(Integer productReviewId){
        Optional<ProductReview> productReviewById = productReviewRepository.findById(productReviewId);
        if(productReviewById.isEmpty()){
            return new ErrorApiResponse<>("Not found", null);
        }
        return new SuccessApiResponse<ProductReview>("Found successfully ", productReviewById.get());
    }

    public ApiResponse<ProductReview> createProductReview(ProductReview productReview){
        ProductReview savedProductReview = productReviewRepository.save(productReview);
        return new SuccessApiResponse<ProductReview>("Successfully added", savedProductReview);

    }

    public ApiResponse<ProductReview> updateProductReview(Integer productReviewId, ProductReview productReview){

        Optional<ProductReview> productReviewById = productReviewRepository.findById(productReviewId);
        if(productReviewById.isEmpty()){
            return new ErrorApiResponse<>("Not found", null);
        }
        productReview.setProductId(productReviewId);
        ProductReview updatedProduct = productReviewRepository.save(productReview);
        return new SuccessApiResponse<>("Updated product review successfully", updatedProduct);

    }

    public ApiResponse<Object> deleteProductReviewById(Integer productReviewId){
        try {
            productReviewRepository.deleteById(productReviewId);
        } catch (Exception ex){
            LOG.error("Error in deletion of the brand ", ex);
            return new ErrorApiResponse<Object>("Brand deletion Failed", null);
        }

        return new SuccessApiResponse<Object>("Brand deletion successful", null);

    }

    public ApiResponse<List<ProductReview>> getProductReviewsByProductId(Integer productId) {
        List<ProductReview> allByProductId = productReviewRepository.findAllByProductId(productId);
        if(allByProductId == null || allByProductId.isEmpty()){
            return new ErrorApiResponse<>("No image found for the given product id", null);
        }else {
            return new SuccessApiResponse<>("Found Images ", allByProductId);
        }

    }
}
