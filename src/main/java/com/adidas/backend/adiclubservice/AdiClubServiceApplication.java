package com.adidas.backend.adiclubservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "AdiClub Service API",
    description = "AdiClub Service API",
    version = "1.0",
    contact = @Contact(name = "Adidas", url = "https://adidas.com")))
public class AdiClubServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdiClubServiceApplication.class, args);
	}

}
