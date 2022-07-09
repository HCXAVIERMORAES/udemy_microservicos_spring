package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//adiciona-se um @RestController, para q o rest o reconheça como um controler
@RestController
public class GreetingController {
	//rest controller para acessar os end Points. onde teremos algumas propriedades
	
	private static final String template = "Hello , % s!";
	private final AtomicLong counter = new AtomicLong();
	
	//metodo
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name" , defaultValue = " Word") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
		
	}

}
