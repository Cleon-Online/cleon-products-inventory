package com.cleon.products.inventory.bootstrap;

import com.cleon.products.inventory.domain.Product;
import com.cleon.products.inventory.domain.ProductCategory;
import com.cleon.products.inventory.domain.ProductInventory;
import com.cleon.products.inventory.domain.ProductType;
import com.cleon.products.inventory.repositories.ProductCategoryRepository;
import com.cleon.products.inventory.repositories.ProductInventoryRepository;
import com.cleon.products.inventory.repositories.ProductRepository;
import com.cleon.products.inventory.repositories.ProductTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * vbala created on 4/4/2020
 * Inside the package - com.cleon.products.inventory.bootstrap
 **/
@Component
@RequiredArgsConstructor
@Slf4j
public class ProductInventoryInitializer implements CommandLineRunner {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductTypeRepository productTypeRepository;
    private final ProductRepository productRepository;
    private final ProductInventoryRepository productInventoryRepository;


    @Override
    public void run(String... args) throws Exception {
        loadProductCategories();
        loadProductTypes();
        loadProducts();
        loadProductInventory();
    }

    private void loadProductCategories() {
        saveProductCategory("Electronics",
                "These are electronics");
        saveProductCategory("Books",
                "These are books");
        saveProductCategory("Fashion",
                "These are fashion products");
    }

    private void saveProductCategory(String name,
                                     String description){
        productCategoryRepository.save(ProductCategory.builder()
                .productCategoryName(name)
                .productCategoryDescription(description)
                .build());
    }

    private void loadProductTypes(){
        saveProductType("Phone",
                "Phone using which you can call",
                productCategoryRepository.findByProductCategoryName("Electronics"));
        saveProductType("Laptop",
                "This is the small computer",
                productCategoryRepository.findByProductCategoryName("Electronics"));
        saveProductType("TV",
                "Television you can watch ",
                productCategoryRepository.findByProductCategoryName("Electronics"));
        saveProductType("Texbook",
                "Textbooks used in College",
                productCategoryRepository.findByProductCategoryName("Books"));
        saveProductType("Fiction",
                "Fictional novels, I usually dont like these",
                productCategoryRepository.findByProductCategoryName("Books"));
        saveProductType("Non-Fiction",
                "I love these",
                productCategoryRepository.findByProductCategoryName("Books"));
        saveProductType("Jewellery",
                "Jewellery for men and women",
                productCategoryRepository.findByProductCategoryName("Fashion"));
        saveProductType("Shoes",
                "Shoes for men and women",
                productCategoryRepository.findByProductCategoryName("Fashion"));
        saveProductType("Apparel",
                "Apparel for men and women",
                productCategoryRepository.findByProductCategoryName("Fashion"));
    }

    private void saveProductType(String productTypeName,
                                 String productTypeDescription,
                                 ProductCategory productCategory){
        productTypeRepository.save(ProductType.builder()
                .productTypeName(productTypeName)
                .productTypeDescription(productTypeDescription)
                .productCategory(productCategory)
                .build());
    }

    private void loadProducts(){
        saveProduct("PH-123-323",
                "iPhone",
                productTypeRepository.findByProductTypeName("Phone"),
                new BigDecimal("1099.99"),
                "00912334123");
        saveProduct("PH-123-324",
                "HP Laptop X360",
                productTypeRepository.findByProductTypeName("Laptop"),
                new BigDecimal("1499.99"),
                "00912334124");
        saveProduct("PH-123-325",
                "LG 60 Inch TV",
                productTypeRepository.findByProductTypeName("TV"),
                new BigDecimal("799.99"),
                "00912334125");
        saveProduct("PH-123-326",
                "Physics X Grade Book",
                productTypeRepository.findByProductTypeName("Texbook"),
                new BigDecimal("29.99"),
                "00912334126");
        saveProduct("PH-123-327",
                "The Stand",
                productTypeRepository.findByProductTypeName("Fiction"),
                new BigDecimal("14.99"),
                "00912334127");
        saveProduct("PH-123-328",
                "Smartest Guys In The Room",
                productTypeRepository.findByProductTypeName("Non-Fiction"),
                new BigDecimal("1099.99"),
                "00912334128");
        saveProduct("PH-123-329",
                "Ring",
                productTypeRepository.findByProductTypeName("Jewellery"),
                new BigDecimal("599.99"),
                "00912334129");
        saveProduct("PH-123-376",
                "Nike Mens Shoes",
                productTypeRepository.findByProductTypeName("Shoes"),
                new BigDecimal("79.99"),
                "00912334176");
        saveProduct("PH-123-377",
                "Ralph Lauren Women's Shirt",
                productTypeRepository.findByProductTypeName("Apparel"),
                new BigDecimal("59.99"),
                "00912334177");
    }

    private void saveProduct(String productNumber,
                             String productName,
                             ProductType productType,
                             BigDecimal productPrice,
                             String serialNumber){
        productRepository.save(Product.builder()
                .productName(productName)
                .productNumber(productNumber)
                .productType(productType)
                .productPrice(productPrice)
                .serialNumber(serialNumber)
                .build());
    }

    private void loadProductInventory(){
        saveProductInventory(
                productRepository.findByProductNumber("PH-123-323"),
                Integer.valueOf(1000));
        saveProductInventory(
                productRepository.findByProductNumber("PH-123-324"),
                Integer.valueOf(1200));
        saveProductInventory(
                productRepository.findByProductNumber("PH-123-325"),
                Integer.valueOf(1100));
        saveProductInventory(
                productRepository.findByProductNumber("PH-123-326"),
                Integer.valueOf(900));
        saveProductInventory(
                productRepository.findByProductNumber("PH-123-327"),
                Integer.valueOf(700));
        saveProductInventory(
                productRepository.findByProductNumber("PH-123-328"),
                Integer.valueOf(500));
        saveProductInventory(
                productRepository.findByProductNumber("PH-123-329"),
                Integer.valueOf(600));
        saveProductInventory(
                productRepository.findByProductNumber("PH-123-376"),
                Integer.valueOf(1350));
        saveProductInventory(
                productRepository.findByProductNumber("PH-123-377"),
                Integer.valueOf(1200));

    }

    private void saveProductInventory(Product product,
                             Integer quantityOnHand){
        productInventoryRepository.save(ProductInventory.builder()
                                    .product(product)
                                    .quantityOnHand(quantityOnHand)
                                    .build());
    }
}
