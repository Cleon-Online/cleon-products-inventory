package com.cleon.products.inventory.domain;

import lombok.*;

import javax.persistence.*;

/**
 * vbala created on 4/4/2020
 * Inside the package - com.cleon.products.inventory.domain
 **/
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductInventory {

    /**
     * Primary key for the product inventory
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_inv_sequence")
    @SequenceGenerator(name="product_inv_sequence", sequenceName = "product_inv_sequence",
            initialValue = 40001, allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long productInventoryId;

    /**
     * The product for which the inventory is mapped to
     */
    private String productNumber;

    /**
     * The total quantity of the product that is available in hand
     * at a point in time
     */
    private Integer quantityOnHand;
}
