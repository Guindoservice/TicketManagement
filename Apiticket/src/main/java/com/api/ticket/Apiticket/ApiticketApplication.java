package com.api.ticket.Apiticket;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication //(exclude = {SecurityAutoConfiguration.class})
//la configurateur de swagger
@OpenAPIDefinition(
		info = @Info(
				title = "Bienvenu sur Ticket Api",
				version = "1.0.0",
				description = "Api des gestion des tickets",
				termsOfService = "Ticket",
				contact = @Contact(
						name = "M. Abdala guindo",
						email = "guindo8.com@gmail.com"
				),
				license = @License(
						name = "malicence",
						url = "apiticket"
				)
		)
)
public class ApiticketApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiticketApplication.class, args);
	}

}
