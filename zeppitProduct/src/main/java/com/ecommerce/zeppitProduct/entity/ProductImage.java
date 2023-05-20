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
@Table(name = "PRODUCT_IMAGES", schema = "ZEPPIT_OWNER")
public class ProductImage {

    @Id
    @Column(name = "IMAGE_ID")
    private Integer imageId;

    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Column(name = "FILENAME")
    private String fileName;


}
