package com.cleon.products.inventory.web.controllers;

import com.cleon.products.inventory.domain.ProductInventory;
import com.cleon.products.inventory.services.IProductInventoryService;
import com.cleon.products.inventory.web.apis.ProductInventoryApi;
import com.cleon.products.inventory.web.model.ProductInventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * vbala created on 4/5/2020
 * Inside the package - com.cleon.products.inventory.web.controllers
 **/
@RequiredArgsConstructor
@RestController
@Slf4j
public class ProductInventoryController implements ProductInventoryApi {

    private final IProductInventoryService productInventoryService;

    @Override
    public ResponseEntity<ProductInventoryDto> getProductInventoryByProductNumber(String productNumber) {
        log.info("Product Number: " + productNumber);
        ProductInventoryDto productInventory = productInventoryService.getProductInventoryByProductNumber(productNumber);
//                ProductInventoryDto productInventory = ProductInventoryDto.builder()
//                                                .quantityOnHand(Integer.valueOf(100)).build();
        log.info("Product Inventory onhand: " + productInventory.getQuantityOnHand());
        return new ResponseEntity<>(productInventory, HttpStatus.OK);
    }
}
