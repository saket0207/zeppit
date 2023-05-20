package com.ecommerce.zeppitProduct.repository;

import com.ecommerce.zeppitProduct.entity.ProductReview;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import static com.ecommerce.zeppitProduct.utility.Constants.FIND_ALL_PR_BY_PRODUCT_ID;

public interface ProductReviewRepository extends CrudRepository<ProductReview, Integer> {

    @Query(value = FIND_ALL_PR_BY_PRODUCT_ID, nativeQuery = true)
    List<ProductReview> findAllByProductId(Integer productId);
}
