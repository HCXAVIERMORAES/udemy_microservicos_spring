package br.com.erudio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

//para simular a erros e commo usar o resilece4j
@Tag(name = "Foo Bar") //documentação
@RestController 
@RequestMapping("book-service")
public class FooBarController {
	
	private Logger logger = LoggerFactory.getLogger(FooBarController.class);
	

	@GetMapping("/foo-bar")
	@Operation(summary = "Foo bar")
	//@Retry(name = "foo-bar",fallbackMethod = "fallbackMethod")
	//@CircuitBreaker(name = "foo-bar",fallbackMethod = "fallbackMethod")
	//@RateLimiter(name = "default")
	@Bulkhead(name = "default")
	public String fooBar() {
		//simulando um erro com uma url que não exist
		//new RestTemplate().getForEntity("http://localhost:8080/foobar", String.class);
		//return "Foo-Bar!!!";
		//pegando o erro e mostrando-o
		logger.info("recebida solicitação para foo-bar");
		//var response =new RestTemplate().getForEntity("http://localhost:8080/foobar", String.class);
				//return response.getBody();
		return "Foo-Bar!!!";
	}
	
	public String fallbackMethod(Exception ex) {
		return "fallbackMethod foo-bar!!!";
	}
}
