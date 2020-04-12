package com.cleon.products.inventory.services;

import com.cleon.products.inventory.domain.Product;
import com.cleon.products.inventory.domain.ProductInventory;
import com.cleon.products.inventory.repositories.ProductInventoryRepository;
import com.cleon.products.inventory.repositories.ProductRepository;
import com.cleon.products.inventory.web.mappers.ProductInventoryMapper;
import com.cleon.products.inventory.web.model.ProductInventoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA
 * User: Balaji Varadharajan
 * Class/Interface/Enum Name: ProductInventoryServiceImpl
 * Inside the package - com.cleon.products.inventory.services
 * Created Date: 4/11/2020
 * Created Time: 9:45 PM
 **/
@Service
@RequiredArgsConstructor
public class ProductInventoryServiceImpl implements IProductInventoryService {

    private final ProductInventoryRepository productInventoryRepository;
    private final ProductRepository productRepository;
    private final ProductInventoryMapper mapper;

    @Override
    public ProductInventoryDto getProductInventoryByProductNumber(String productNumber) {
        Product product = productRepository.findByProductNumber(productNumber);
        ProductInventory productInventory = productInventoryRepository.findByProduct(product);
        if(productInventory!=null){
            ProductInventoryDto productInventoryDto = mapper.productInventoryToProductInventoryDto(productInventory);
            return productInventoryDto;
        }
        return null;
    }
}
