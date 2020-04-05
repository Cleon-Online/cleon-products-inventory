package com.cleon.products.inventory.web.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


/**
 * vbala created on 4/5/2020
 * Inside the package - com.cleon.products.inventory.web.model
 **/
@Getter
@Setter
@Builder
public class ProductInventoryDto {
    private Integer quantityOnHand;
}
