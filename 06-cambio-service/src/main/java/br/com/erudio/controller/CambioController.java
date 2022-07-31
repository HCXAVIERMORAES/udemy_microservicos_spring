package br.com.erudio.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Cambio;
import br.com.erudio.repository.CambioRepository;

@RestController
@RequestMapping("cambio-service")
public class CambioController {
	
	/*
	*http:localhost//8000/cambio-service/5/USD/BRL -> mapiamento da url a ser usada
	*amount = total convertido
	*O getProperty() se consegue acessar varias informações sobre a aplicação
	*apos trocar o: return new Cambio(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, "PORTA 8000"), trocandoa string pela variavel port
	*/
	@Autowired
	private Environment environment;
	
	@Autowired
	private CambioRepository repository;
	
	@GetMapping(value = "/{amount}/{from}/{to}")
	public Cambio getCambio(
			@PathVariable("amount") BigDecimal amount,
			@PathVariable("from") String from,
			@PathVariable("to") String to
			) {
				
		var cambio = repository.findByFromAndTo(from, to);
		//fazendo uma verificação e lançando mensagem se houver erro
		if(cambio == null) throw new RuntimeException("Moeda não suportada");
		
		//recuperando a porta de excução da instancia. 
		var port = environment.getProperty("local.server.port");
		//mostrando o valor convertido
		BigDecimal conversionFactor = cambio.getConversionFactor(); //pegando o fator de conversao
		BigDecimal convertedValue = conversionFactor.multiply(amount); //fazendo a conversao ( valor convertido)
		//setando o valor convertido para cambio com duas casas decimais
		cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
		cambio.setEnvironment(port); //setando a porta
		
		//o retorno segui o construtor da classe cambio 
		//return new Cambio(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, port); mok
		return cambio;
	}

}
