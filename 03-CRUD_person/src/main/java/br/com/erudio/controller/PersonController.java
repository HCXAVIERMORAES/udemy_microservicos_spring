package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;
/*
 * adiciona-se um @RestController, para q o rest o reconheça como um controler
 * @RequestMapping("/person") sufixo para todos os endPpoints deste método
 * O @Autowired é o mesmo que fazer private PersonServices service = new PersonServices();
 * Verbo POST - não se acessa pelo browse sem outra tecnologia, como javaScript, PHP, etc então se usa o Postmam
 * @RequestBody corpo da requisição
 */

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices services;
	
	//retornando uma lista, obs: deve-se retirar o id pois com ele tem-se um erro de ambiguidade
		@RequestMapping(method = RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Person> findAll() {				
			return services.findAll();	
		}
		
	@RequestMapping(value = "/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable("id")String id) {		
		
		return services.findById(id); //retorna um services recebendo o id passado com parâmetro
	}
	
	//metodo para o POST - ele consome e produz JASON
	@RequestMapping(method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person) {				
		return services.create(person);	
	}
	
	//metodo para o PUT para fazer alteração - ele consome e produz JASON
		@RequestMapping(method = RequestMethod.PUT,
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public Person update(@RequestBody Person person) {				
			return services.update(person);	
		}
		
		//metodo para excluir um dado atravez de um id
		@RequestMapping(value = "/{id}",
				method = RequestMethod.DELETE)
		public void delete(@PathVariable("id")String id) {		
			
			services.delete(id); 
		}
	
	
	
}// fim classe PersonController
