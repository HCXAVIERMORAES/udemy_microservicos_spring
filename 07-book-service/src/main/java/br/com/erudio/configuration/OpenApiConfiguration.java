package br.com.erudio.configuration;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

//documentação do swagger 
@OpenAPIDefinition(info =
@Info(title= "Book Service API",
		version = "V1",
		description = "Documentação do Book Service API"))
public class OpenApiConfiguration {
	
	//colocar um bean
	@Bean
	public OpenAPI CustomOpenAPI() {
		
		return new OpenAPI()
				.components(new Components())
				.info(new io.swagger.v3.oas.models.info.Info()
						.title("Book Service API")
						.version("V1")
						.license(new License()
								.name("Apache 2.0")
								.url("http://springdoc.org")
								)
						);
		
	}

}
