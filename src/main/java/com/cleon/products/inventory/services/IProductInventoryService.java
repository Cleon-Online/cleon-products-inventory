package com.cleon.products.inventory.services;

import com.cleon.products.inventory.web.model.ProductInventoryDto;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: IProductInventoryService
 * Inside the package - com.cleon.products.inventory.services
 * Created Date: 4/11/2020
 * Created Time: 9:44 PM
 **/
public interface IProductInventoryService {
    ProductInventoryDto getProductInventoryByProductNumber(String productNumber);
}
