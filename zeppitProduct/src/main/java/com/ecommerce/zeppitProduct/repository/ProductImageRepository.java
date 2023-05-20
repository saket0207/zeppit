package com.ecommerce.zeppitProduct.repository;

import com.ecommerce.zeppitProduct.entity.ProductImage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import static com.ecommerce.zeppitProduct.utility.Constants.FIND_ALL_PI_BY_PRODUCT_ID;

public interface ProductImageRepository extends CrudRepository<ProductImage, Integer> {

    @Query(value = FIND_ALL_PI_BY_PRODUCT_ID, nativeQuery = true)
    List<ProductImage> fetchAllByProductId(Integer productId);
}
