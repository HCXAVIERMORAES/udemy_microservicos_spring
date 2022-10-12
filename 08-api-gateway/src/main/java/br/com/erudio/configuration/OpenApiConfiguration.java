package br.com.erudio.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class OpenApiConfiguration {
	
	//criar um metodo do tipo list q recebe dois parametros
	@Bean
	@Lazy(false)  //é false para que seja carregada assim q a aplicação seja inicializada
	public List<GroupedOpenApi> apis(
			SwaggerUiConfigParameters config , 
			RouteDefinitionLocator locator) {
		//definição dos parametros
		//adicionar uma lista de RouteDefinitions
		var definitions = locator.getRouteDefinitions().collectList().block(); //deve-se garantir  q será bloqueado (block())
		
		//filtrar os serviços, puchando o que tem service no .yml e adiciona no grupo
		definitions.stream().filter(
				routeDefinition -> routeDefinition.getId()
				.matches(".*-service"))
					.forEach(routeDefinition ->{
						String name = routeDefinition.getId();
						config.addGroup(name);//configurações do swagger
						GroupedOpenApi.builder()
							.pathsToMatch("/" + name + "/**") //
							.group(name).build();
					}
				);
		return new ArrayList<>();
		
	}

}
