package com.cleon.products.inventory.web.apis;

import com.cleon.products.inventory.web.model.ProductInventoryDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * vbala created on 4/5/2020
 * Inside the package - com.cleon.products.inventory.web.apis
 **/
@Tag(name = "Product Inventory ", description = "The products inventory API")
public interface ProductInventoryApi {

    @Operation(
            summary = "Get Product Inventory",
            description = "Find the inventory of the given product number",
//            tags = {
//                    "product"
//            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful Operation",
                            content = {
                                    @Content(
                                            schema = @Schema(implementation = ProductInventoryDto.class)
                                    )
                            }
                    )
            }
    )
    @GetMapping(value = "/product-inventory/{productNumber}",produces = {"application/json"})
    ResponseEntity<ProductInventoryDto> getProductInventoryByProductNumber(@PathVariable("productNumber") String productNumber);
}
