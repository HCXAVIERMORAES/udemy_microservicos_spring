package br.com.erudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erudio.model.Cambio;

/*repositorio da base de dados do jpa, dando um CRUD completo,
 * tem um retorno Cambio String from e String to, que gera um sql baseado em um findBy usando 
 * as colunas from e to da tabela cambio */

public interface CambioRepository extends JpaRepository<Cambio, Long>{

	
	Cambio findByFromAndTo(String form, String to);
}
