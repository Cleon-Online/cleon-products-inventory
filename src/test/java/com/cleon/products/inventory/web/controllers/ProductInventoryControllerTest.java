package com.cleon.products.inventory.web.controllers;

import com.cleon.products.inventory.services.IProductInventoryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductInventoryController.class)
class ProductInventoryControllerTest {

    @MockBean
    IProductInventoryService productInventoryService;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getProductInventoryByProductNumber() throws Exception {
        mockMvc.perform(get(
                "/products/" + "PH-123-324" +"/inventory")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}