package com.ecommerce.zeppitProduct.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_REVIEW", schema = "ZEPPIT_OWNER")
public class ProductReview {

    @Id
    @Column(name = "REVIEW_ID")
    private Integer reviewId;

    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Column(name = "PRODUCT_RATING")
    private Integer productRating;

    @Column(name = "COMMENT")
    private String comment;
}
