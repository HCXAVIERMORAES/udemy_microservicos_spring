package br.com.erudio.configuration;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//configuração de rotas 
@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		
		//lambida function q vai intercepitar o /get
		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f 
								.addRequestHeader("Hello", "Word")    //passa um cabeçalho
								.addRequestParameter("Hello", "Word")) //passa um parametro
						.uri("http://httpbin.org:80"))
				.route(p -> p.path("/cambio-service/**")
						.uri("lb://cambio-service"))
				.route(p -> p.path("/book-service/**")
						.uri("lb://book-service")) //eureka
				.build();
		
	}
}
