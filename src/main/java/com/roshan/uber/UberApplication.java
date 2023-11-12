package com.roshan.uber;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
