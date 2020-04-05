package com.cleon.products.inventory.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * vbala created on 4/5/2020
 * Inside the package - com.cleon.products.inventory.config
 **/
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customConfiguration(){
        List<Server> serverList = new ArrayList<>();
        serverList.add(new Server().url("http://localhost:8080").description("Development Server"));
        serverList.add(new Server().url("http://qa.cleon-product-inventory.com").description("QA Server"));
        serverList.add(new Server().url("http://prod.cleon-product-inventory.com").description("Production Server"));
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Cleon Product Inventory API")
                        .description("API Documentation for Cleon Product Inventory")
                        .version("1.0.0")
                        .contact(new Contact().email("vbalaji215@gmail.com").url("http://cleonproducts.com")))
                .servers(serverList);
    }
}
