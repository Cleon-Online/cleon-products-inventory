package com.cleon.products.inventory.bootstrap;

import com.cleon.products.inventory.domain.ProductInventory;
import com.cleon.products.inventory.repositories.ProductInventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * vbala created on 4/4/2020
 * Inside the package - com.cleon.products.inventory.bootstrap
 **/
@Component
@RequiredArgsConstructor
@Slf4j
public class ProductInventoryInitializer implements CommandLineRunner {

    private final ProductInventoryRepository productInventoryRepository;


    @Override
    public void run(String... args) throws Exception {
        loadProductInventory();
    }


    private void loadProductInventory(){
        saveProductInventory(
                "PH-123-323",
                Integer.valueOf(1000));
        saveProductInventory(
                "PH-123-324",
                Integer.valueOf(1200));
        saveProductInventory(
                "PH-123-325",
                Integer.valueOf(1100));
        saveProductInventory(
                "PH-123-326",
                Integer.valueOf(900));
        saveProductInventory(
                "PH-123-327",
                Integer.valueOf(700));
        saveProductInventory(
                "PH-123-328",
                Integer.valueOf(500));
        saveProductInventory(
                "PH-123-329",
                Integer.valueOf(600));
        saveProductInventory(
                "PH-123-376",
                Integer.valueOf(1350));
        saveProductInventory(
               "PH-123-377",
                Integer.valueOf(1200));

    }

    private void saveProductInventory(String productNumber,
                             Integer quantityOnHand){
        productInventoryRepository.save(ProductInventory.builder()
                                    .productNumber(productNumber)
                                    .quantityOnHand(quantityOnHand)
                                    .build());
    }
}
