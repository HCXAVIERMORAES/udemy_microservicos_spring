package br.com.erudio.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.erudio.response.Cambio;

//adiciona a anotação de feign
@FeignClient(name="cambio-service",url="localhost:8000")
public interface CambioProxy {
	
	//copiado o metodo do cambio-service e passar o caminho
	@GetMapping(value = "/cambio-service/{amount}/{from}/{to}")
	public Cambio getCambio(
			@PathVariable("amount") Double amount,
			@PathVariable("from") String from,
			@PathVariable("to") String to
			);

}
