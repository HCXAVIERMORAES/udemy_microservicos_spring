package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.configuration.GreetingConfiguration;
import br.com.erudio.model.Greeting;

@RestController
public class GreetingController {
	
	//private static final String template = "Hello , %s!";//substituido pelo parametro recebido do arquivo .yml
	private static final String template = "%s, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	//instanciar a classe de configuração
	@Autowired
	private GreetingConfiguration configuration;	
	
	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value = "name" , 
			//defaultValue = " Word") String name) substituido por 
			defaultValue = "") String name) {
		
		//fazendo uma validação do parametro passado
		if(name.isEmpty()) name= configuration.getDefaultValue();
		
		return new Greeting(
				counter.incrementAndGet(),
				//String.format(template, name) substituido por
				String.format(template, configuration.getGreeting(), name)
				);
		
	}

}
