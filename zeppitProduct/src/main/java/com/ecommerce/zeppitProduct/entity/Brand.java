package com.ecommerce.zeppitProduct.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "BRAND", schema = "ZEPPIT_OWNER")
public class Brand {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRAND_ID")
    private Integer brandId;

    @Column(name = "BRAND_NAME")
    private String brandName;
}

