package com.cleon.products.inventory.web.mappers;

import com.cleon.products.inventory.domain.ProductInventory;
import com.cleon.products.inventory.web.model.ProductInventoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: ProductInventoryMapper
 * Inside the package - com.cleon.products.inventory.web.mappers
 * Created Date: 4/11/2020
 * Created Time: 8:59 PM
 **/
@Mapper
public interface ProductInventoryMapper {

//    @Mapping(source = "productId", target = "product.productId")
//    @Mapping(source = "productNumber", target = "product.productNumber")
//    @Mapping(source = "productName", target = "product.productName")
    ProductInventory productInventoryDtoToProductInventory(ProductInventoryDto productInventoryDto);

//    @Mapping(source = "product.productId", target = "productId")
//    @Mapping(source = "product.productNumber", target = "productNumber")
//    @Mapping(source = "product.productName", target = "productName")
    ProductInventoryDto productInventoryToProductInventoryDto(ProductInventory productInventory);
}
