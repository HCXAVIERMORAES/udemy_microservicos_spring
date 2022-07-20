package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

/*
 * A anotação @service, serve para que o spring cuide da injeção de dependencia dessa classe onde for necessário,
 * ou seja, quando for usar essa classe em outra classe não é presciso dar um new nela ou fazer um static. Pode-se
 * simplesmente adicionar um @Autowired e ele cuida disso
 * */
@Service
public class PersonServices  {

	//atributo q vai servir para simular um id do banco de dados
	private final AtomicLong counter = new AtomicLong();
	
	//verbo POST - muito usada na persistencia, gravação de dados
	public Person create(Person person) {
		//aqui vai a lógica q vai a base de dados
		return person;
	}
	
	//para update usa-se o verbo PUT - alteração de dados
	public Person update(Person person) {
		//aqui vai a lógica q vai a base de dados
		return person;
	}
	
	//para deletar usa-se o verbo DELETE - exclui dados
		public void delete(String id) {
			//aqui vai a lógica q vai a base de dados, se encontrar o id passado este é apagado 
			//senão retorna-se um erro.
			
		}
	public Person findById(String id) {
		
		Person person = new Person();
		
		person.setId(counter.incrementAndGet()); //gera um numero, pega ele e incrementa-lo
		person.setFristName("Helton");
		person.setLastName("Moraes");
		person.setAddress("Betim - Minas Gerais - Brasil");
		person.setGender("Masculino");
		
		return person;		
	}
	
	//retornando uma lista de pessoas (em mock posis não ha um banco de dados
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		for (int i=0; i<8; i++) {
			Person person = mockPerson(i);
			persons.add(person);			
		}
		return persons;
	
	}

	//método do mockPerson
	private Person mockPerson(int i) {
		Person person = new Person();
		
		person.setId(counter.incrementAndGet()); //gera um numero, pega ele e incrementa-lo
		person.setFristName("Person name "+i);
		person.setLastName("Last name "+i);
		person.setAddress("Endereço no Brasil" + 1);
		person.setGender("Masculino");
		
		return person;	
	}
		
		
}
	
	

