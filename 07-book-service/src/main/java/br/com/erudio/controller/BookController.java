	package br.com.erudio.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.erudio.model.Book;
import br.com.erudio.proxy.CambioProxy;
import br.com.erudio.repository.BookRepository;
import br.com.erudio.response.Cambio;

@RestController 
@RequestMapping("book-service")
public class BookController {

	@Autowired
	private Environment envirionment; //port
	
	@Autowired
	private BookRepository repository; //injetando repositorio criado
	
	@Autowired
	private CambioProxy proxy;
	
	//metodo ou end point
	@GetMapping(value = "/{id}/{currency}")
	public Book findBook(
			@PathVariable("id") Long id,
			@PathVariable("currency") String currency
			) {
		
		var book = repository.getById(id);
		if(book == null) throw new RuntimeException("Livro NÃO Encontrado");
		
		var cambio = proxy.getCambio(book.getPrice(), "USD", currency);
		
		var port = envirionment.getProperty("local.server.port"); //buscando a porta
		
		book.setEnvironment("port"+ " FEIGN");
		book.setPrice(cambio.getConvertedValue());
		return book;
		
	}
	
	/*//metodo ou end point
	@GetMapping(value = "/{id}/{currency}")
	public Book findBook(
			@PathVariable("id") Long id,
			@PathVariable("currency") String currency
			) {
		
		var book = repository.getById(id);
		if(book == null) throw new RuntimeException("Livro NÃO Encontrado");
		
		//consumindo o endpoint de cambio
		
		
		HashMap<String, String> params = new HashMap<>();
		params.put("amount", book.getPrice().toString());
		params.put("from", "USD"); //USD esta como padrão se mudar alguma coisa segui-se talvez como o acima
		params.put("to", currency);
		
		var response = new RestTemplate()
			.getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}",
					Cambio.class, 
					params);
		var cambio = response.getBody();
		
		var port = envirionment.getProperty("local.server.port"); //buscando a porta
		
		book.setEnvironment("port");
		//setando os atributos: Book(Long id, String author, String title, Date launchDate, Double price, String currency,String environment)
		//retornando um mook seguindo o construtor
		//return new Book(1L,"Nigel Poulton", "docker Deep Diver", new Date(),
				//Double.valueOf(13.7), currency, port);
		book.setPrice(cambio.getConvertedValue());
		return book;
		
	}*/
}
