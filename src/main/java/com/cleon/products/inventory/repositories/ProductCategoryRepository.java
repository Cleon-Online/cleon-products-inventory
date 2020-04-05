package com.cleon.products.inventory.repositories;

import com.cleon.products.inventory.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * vbala created on 4/4/2020
 * Inside the package - com.cleon.products.inventory.repositories
 **/
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    ProductCategory findByProductCategoryName(String productCategoryName);
}
