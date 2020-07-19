package com.shopizer.shipping.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Shopizer shipping rules management",
                description = "" +
                        "Shipping rules management",
                contact = @Contact(name = "Shopizer", url = "https://www.shopizer.com", email = "carl@shopizer.com"),
                license = @License(name = "GPL Licence", url = "")),
        servers = @Server(url = "http://localhost:8080")
)
public class OpenApiConfiguration {

}
