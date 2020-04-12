package com.cleon.products.inventory.web.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;


/**
 * vbala created on 4/5/2020
 * Inside the package - com.cleon.products.inventory.web.model
 **/
@Getter
@Setter
@Builder
public class ProductInventoryDto {
    private Long productId;
    private String productNumber;
    private Long productInventoryId;
    private String productName;
    private Integer quantityOnHand;
//    private OffsetDateTime createdDate;
//    private OffsetDateTime lastModifiedDate;
}
