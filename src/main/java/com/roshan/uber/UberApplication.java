package com.roshan.uber;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan(basePackages = {"com.roshan.uber.services.impls","com.roshan.uber.adaptors","com.roshan.uber.configs"
		,"com.roshan.uber.controllers","com.roshan.uber.dtos","com.roshan.uber.enums","com.roshan.uber.exceptions"
		,"com.roshan.uber.models","com.roshan.uber.repositories","com.roshan.uber.services","com.roshan.uber.utils"})
@OpenAPIDefinition(
		info = @Info(
				title = "Uber Server Application",
				version = "1.0.0",
				description = "This mockup of Uber application.",
				contact = @Contact(
				name = "Roshan",
				email = "roshankumar.s.2512@gmail.com"
				)
		)
)
public class UberApplication {

	public static void main(String[] args) {
		SpringApplication.run(UberApplication.class, args);
	}

}
