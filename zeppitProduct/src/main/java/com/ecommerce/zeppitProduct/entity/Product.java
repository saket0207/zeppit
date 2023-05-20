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
@Table(name = "PRODUCT", schema = "ZEPPIT_OWNER")
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String productDescription;

    @Column(name = "PRODUCT_UNIT_PRICE")
    private Double productUnitPrice;

    @Column(name = "PRODUCT_QUANTITY")
    private Integer productQuantity;

    @Column(name = "CATEGORY_ID")
    private Integer categoryId;

    @Column(name = "BRAND_ID")
    private Integer brandID;


}
